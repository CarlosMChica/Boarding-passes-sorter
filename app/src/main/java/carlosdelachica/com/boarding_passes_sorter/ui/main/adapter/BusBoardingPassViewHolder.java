package carlosdelachica.com.boarding_passes_sorter.ui.main.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlosdelachica.boarding_passes_sorter.model.BusBoardingPass;

import carlosdelachica.com.boarding_passes_sorter.R;

public class BusBoardingPassViewHolder extends BasicBoardingPassViewHolder<BusBoardingPass> {

    private final Context context;
    private TextView transportTextView;
    private TextView seatTextView;

    public BusBoardingPassViewHolder(Context context, ViewGroup parent) {
        super(context, parent);
        this.context = context;
        bindViews();
    }

    private void bindViews() {
        seatTextView = ((TextView) itemView.findViewById(R.id.extraInfoTextView));
        transportTextView = ((TextView) itemView.findViewById(R.id.transportTextView));
    }

    @Override
    protected void bindBoardingPass(BusBoardingPass boardingPass) {
        bindTransport(boardingPass.getBusName());
        bindSeat();
    }

    private void bindTransport(String busName) {
        transportTextView.setText(context.getString(R.string.take_bus, busName));
    }

    private void bindSeat() {
        seatTextView.setText(context.getString(R.string.no_seat));
    }

}
