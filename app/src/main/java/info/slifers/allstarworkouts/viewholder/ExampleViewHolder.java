package info.slifers.allstarworkouts.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import info.slifers.allstarworkouts.PlayerData;
import info.slifers.allstarworkouts.R;

public class ExampleViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvText;

    public ExampleViewHolder(View itemView) {
        super(itemView);

        tvText = (TextView) itemView.findViewById(R.id.tvText);
    }

    public void bind(PlayerData player) {
        tvText.setText(player.getName());
    }
}
