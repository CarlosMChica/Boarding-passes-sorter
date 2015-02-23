package carlosdelachica.com.boarding_passes_sorter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.carlosdelachica.boarding_passes_sorter.model.BoardingPass;
import com.carlosdelachica.boarding_passes_sorter.sorter.BoardingPassesSorter;
import com.carlosdelachica.boarding_passes_sorter.sorter.BoardingPassesSorterImp;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyRecyclerAdapter;
import com.carlosdelachica.easyrecycleradapters.recycler_view_manager.EasyRecyclerViewManager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private EasyRecyclerViewManager easyRecyclerViewManager;
    private RecyclerView recyclerView;
    private Button sortTripButton;
    private BoardingPassesSorter boardingPassesSorter = new BoardingPassesSorterImp();
    private ArrayList<BoardingPass> boardingPasses = new ArrayList<>();


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
        EasyRecyclerAdapter adapter = new EasyRecyclerAdapter(this, BoardingPass.class, BoardingPassViewHolder.class);
        easyRecyclerViewManager = new EasyRecyclerViewManager.Builder(recyclerView, adapter)
                .recyclerViewHasFixedSize(true)
                .build();
    }

    private void initSortTripButton() {
        sortTripButton.setOnClickListener(this);
    }

    private void initData() {
        boardingPasses.add(new BoardingPass("London", "New York JFK", "7B", "plane"));
        boardingPasses.add(new BoardingPass("Barcelona", "Gerona Airport", "", "bus"));
        boardingPasses.add(new BoardingPass("Madrid", "Barcelona", "45B", "train"));
        boardingPasses.add(new BoardingPass("Gerona Airport", "London", "3A", "plane"));
        easyRecyclerViewManager.addAll(boardingPasses);
    }

    @Override
    public void onClick(View v) {
        List<BoardingPass> sortedBoardingPasses = boardingPassesSorter.sort(boardingPasses);
        easyRecyclerViewManager.addAll(sortedBoardingPasses);
    }

}
