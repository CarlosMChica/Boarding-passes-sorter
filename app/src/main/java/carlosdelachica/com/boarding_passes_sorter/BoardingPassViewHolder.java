package carlosdelachica.com.boarding_passes_sorter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlosdelachica.boarding_passes_sorter.model.BoardingPass;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;

public class BoardingPassViewHolder extends EasyViewHolder<BoardingPass> {

    private final Context context;
    private TextView originTextView;
    private TextView transportTextView;
    private TextView seatTextView;
    private TextView destinationTextView;

    public BoardingPassViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.boarding_pass_item_layout);
        this.context = context;
        bindViews();
    }

    private void bindViews() {
        originTextView = ((TextView) itemView.findViewById(R.id.originTextView));
        destinationTextView = ((TextView) itemView.findViewById(R.id.destinationTextView));
        seatTextView = ((TextView) itemView.findViewById(R.id.seatTextView));
        transportTextView = ((TextView) itemView.findViewById(R.id.transportTextView));
    }

    @Override
    public void bindTo(BoardingPass boardingPass) {
        originTextView.setText(context.getString(R.string.origin, boardingPass.getOrigin()));
        destinationTextView.setText(context.getString(R.string.destination, boardingPass.getDestination()));
        transportTextView.setText(context.getString(R.string.transport, boardingPass.getTransport()));
        if (!TextUtils.isEmpty(boardingPass.getSeat())) {
            seatTextView.setVisibility(View.VISIBLE);
            seatTextView.setText(context.getString(R.string.seat, boardingPass.getSeat()));
        }
    }

}
