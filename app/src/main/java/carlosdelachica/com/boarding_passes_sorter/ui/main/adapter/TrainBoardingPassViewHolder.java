package carlosdelachica.com.boarding_passes_sorter.ui.main.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlosdelachica.boarding_passes_sorter.model.TrainBoardingPass;

import carlosdelachica.com.boarding_passes_sorter.R;

public class TrainBoardingPassViewHolder extends BasicBoardingPassViewHolder<TrainBoardingPass> {

    private final Context context;
    private TextView transportTextView;
    private TextView extraInfoTextView;

    public TrainBoardingPassViewHolder(Context context, ViewGroup parent) {
        super(context, parent);
        this.context = context;
        bindViews();
    }

    private void bindViews() {
        extraInfoTextView = ((TextView) itemView.findViewById(R.id.extraInfoTextView));
        transportTextView = ((TextView) itemView.findViewById(R.id.transportTextView));
    }

    @Override
    protected void bindBoardingPass(TrainBoardingPass boardingPass) {
        bindTransport(boardingPass);
        bindExtraInfo(boardingPass);
    }

    private void bindTransport(TrainBoardingPass trainBoardingPass) {
        transportTextView.setText(context.getString(R.string.take_train, trainBoardingPass.getTrainNumber()));
    }

    private void bindExtraInfo(TrainBoardingPass trainBoardingPass) {
        extraInfoTextView.setText(context.getString(R.string.train_extra_info, trainBoardingPass.getSeat()));
    }

}
