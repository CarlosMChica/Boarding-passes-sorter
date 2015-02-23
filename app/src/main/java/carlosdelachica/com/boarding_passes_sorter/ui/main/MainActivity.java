package carlosdelachica.com.boarding_passes_sorter.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.carlosdelachica.boarding_passes_sorter.model.BasicBoardingPass;
import com.carlosdelachica.boarding_passes_sorter.model.BusBoardingPass;
import com.carlosdelachica.boarding_passes_sorter.model.PlaneBoardingPass;
import com.carlosdelachica.boarding_passes_sorter.model.TrainBoardingPass;
import com.carlosdelachica.boarding_passes_sorter.sorter.BoardingPassesSorter;
import com.carlosdelachica.boarding_passes_sorter.sorter.BoardingPassesSorterImp;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyRecyclerAdapter;
import com.carlosdelachica.easyrecycleradapters.recycler_view_manager.EasyRecyclerViewManager;

import java.util.ArrayList;
import java.util.List;

import carlosdelachica.com.boarding_passes_sorter.R;
import carlosdelachica.com.boarding_passes_sorter.ui.main.adapter.BoardingPassesViewHolderFactory;
import carlosdelachica.com.boarding_passes_sorter.ui.main.adapter.BusBoardingPassViewHolder;
import carlosdelachica.com.boarding_passes_sorter.ui.main.adapter.PlaneBoardingPassViewHolder;
import carlosdelachica.com.boarding_passes_sorter.ui.main.adapter.TrainBoardingPassViewHolder;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EasyRecyclerViewManager easyRecyclerViewManager;
    private RecyclerView recyclerView;
    private Button sortTripButton;
    private BoardingPassesSorter boardingPassesSorter = new BoardingPassesSorterImp();
    private ArrayList<BasicBoardingPass> basicBoardingPasses = new ArrayList<>();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        initData();
    }

    private void initUi() {
        bindViews();
        initRecyclerView();
        initSortTripButton();
    }

    private void bindViews() {
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        sortTripButton = ((Button) findViewById(R.id.sortTripButton));
    }

    private void initRecyclerView() {
        EasyRecyclerAdapter adapter = initAdapter();
        easyRecyclerViewManager = new EasyRecyclerViewManager.Builder(recyclerView, adapter)
                .emptyLoadingListTextView((TextView) findViewById(R.id.empty_loading_text_view))
                .recyclerViewHasFixedSize(true)
                .build();
    }

    private EasyRecyclerAdapter initAdapter() {
        BoardingPassesViewHolderFactory viewHolderFactory = new BoardingPassesViewHolderFactory(this);
        EasyRecyclerAdapter adapter = new EasyRecyclerAdapter(viewHolderFactory);
        adapter.bind(BusBoardingPass.class, BusBoardingPassViewHolder.class);
        adapter.bind(PlaneBoardingPass.class, PlaneBoardingPassViewHolder.class);
        adapter.bind(TrainBoardingPass.class, TrainBoardingPassViewHolder.class);
        return adapter;
    }

    private void initSortTripButton() {
        sortTripButton.setOnClickListener(this);
    }

    private void initData() {
        basicBoardingPasses.add(new PlaneBoardingPass("London", "New York JFK", "7B", "22", "SK22", "Baggage will be automatically transferred from your last leg"));
        basicBoardingPasses.add(new BusBoardingPass("Barcelona", "Gerona Airport", "airport"));
        basicBoardingPasses.add(new TrainBoardingPass("Madrid", "Barcelona", "45B", "78A"));
        basicBoardingPasses.add(new PlaneBoardingPass("Gerona Airport", "London", "3A", "45B", "SK455", "Baggage drop at ticket counter 344"));
        easyRecyclerViewManager.addAll(basicBoardingPasses);
    }

    @Override
    public void onClick(View v) {
        easyRecyclerViewManager.onRefresh();
        sortTrip();

    }

    private void sortTrip() {
        //Simulate loading time
        handler.postDelayed(new Runnable() {
            public void run() {
                List<BasicBoardingPass> sortedBasicBoardingPasses = boardingPassesSorter.sort(basicBoardingPasses);
                easyRecyclerViewManager.addAll(sortedBasicBoardingPasses);
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
    }

}
