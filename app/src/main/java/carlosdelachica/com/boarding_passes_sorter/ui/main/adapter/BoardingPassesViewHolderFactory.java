package carlosdelachica.com.boarding_passes_sorter.ui.main.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.carlosdelachica.boarding_passes_sorter.model.BusBoardingPass;
import com.carlosdelachica.boarding_passes_sorter.model.PlaneBoardingPass;
import com.carlosdelachica.boarding_passes_sorter.model.TrainBoardingPass;
import com.carlosdelachica.easyrecycleradapters.adapter.BaseEasyViewHolderFactory;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;

public class BoardingPassesViewHolderFactory extends BaseEasyViewHolderFactory {

    public BoardingPassesViewHolderFactory(Context context) {
        super(context);
    }

    @Override
    public EasyViewHolder create(Class valueClass, ViewGroup parent) {
        if (valueClass == PlaneBoardingPass.class) {
            return new PlaneBoardingPassViewHolder(context, parent);
        } else if (valueClass == TrainBoardingPass.class) {
            return new TrainBoardingPassViewHolder(context, parent);
        } else if (valueClass == BusBoardingPass.class) {
            return new BusBoardingPassViewHolder(context, parent);
        }
        return null;
    }


}
