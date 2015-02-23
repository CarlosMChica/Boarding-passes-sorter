package carlosdelachica.com.boarding_passes_sorter.ui.main.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlosdelachica.boarding_passes_sorter.model.BasicBoardingPass;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;

import carlosdelachica.com.boarding_passes_sorter.R;

public abstract class BasicBoardingPassViewHolder<T extends BasicBoardingPass> extends EasyViewHolder<T> {

    private final Context context;
    private TextView originDestinationTextView;

    public BasicBoardingPassViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.boarding_pass_item_layout);
        this.context = context;
        bindViews();
    }

    private void bindViews() {
        originDestinationTextView = ((TextView) itemView.findViewById(R.id.originDestinationTextView));
    }

    @Override
    public final void bindTo(T boardingPass) {
        bindOriginDestination(boardingPass.getOrigin(), boardingPass.getDestination());
        bindBoardingPass(boardingPass);
    }

    private void bindOriginDestination(String origin, String destination) {
        originDestinationTextView.setText(
                context.getString(R.string.origin_destination,
                        origin,
                        destination));
    }

    protected abstract void bindBoardingPass(T boardingPass);

}
