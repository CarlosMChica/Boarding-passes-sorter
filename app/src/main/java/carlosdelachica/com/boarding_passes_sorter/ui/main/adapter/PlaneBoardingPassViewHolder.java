package carlosdelachica.com.boarding_passes_sorter.ui.main.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlosdelachica.boarding_passes_sorter.model.PlaneBoardingPass;

import carlosdelachica.com.boarding_passes_sorter.R;

public class PlaneBoardingPassViewHolder extends BasicBoardingPassViewHolder<PlaneBoardingPass> {

    private final Context context;
    private TextView transportTextView;
    private TextView extraInfoTextView;

    public PlaneBoardingPassViewHolder(Context context, ViewGroup parent) {
        super(context, parent);
        this.context = context;
        bindViews();
    }

    private void bindViews() {
        extraInfoTextView = ((TextView) itemView.findViewById(R.id.extraInfoTextView));
        transportTextView = ((TextView) itemView.findViewById(R.id.transportTextView));
    }

    @Override
    protected void bindBoardingPass(PlaneBoardingPass boardingPass) {
        bindFlightNumber(boardingPass.getFlightNumber());
        bindExtraInfo(boardingPass.getSeat(), boardingPass.getGate(), boardingPass.getBaggageInfo());
    }

    private void bindFlightNumber(String transport) {
        transportTextView.setText(context.getString(R.string.take_plane, transport));
    }

    private void bindExtraInfo(String seat, String gate, String baggageInfo) {
        extraInfoTextView.setText(context.getString(R.string.flight_extra_info, seat, gate, baggageInfo));
    }

}
