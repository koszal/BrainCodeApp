package braincode.app.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import braincode.app.R;
import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class LoadingView extends RelativeLayout {

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.message)
    TextView message;
    @Bind(R.id.actionButton)
    Button actionButton;

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View root = LayoutInflater.from(context).inflate(R.layout.view_loading, this, true);
        ButterKnife.bind(this, root);
    }

    public LoadingView show() {
        this.setVisibility(View.VISIBLE);
        return this;
    }

    public void withProgressBar() {
        this.progressBar.setVisibility(View.VISIBLE);
        this.message.setVisibility(View.GONE);
        this.actionButton.setVisibility(View.GONE);
    }

    public void withMessage(String msg) {
        this.progressBar.setVisibility(View.GONE);
        this.message.setText(msg);
        this.message.setVisibility(View.VISIBLE);
        this.actionButton.setVisibility(View.GONE);
    }

    public void withButton(String msg, String action, OnClickListener listener) {
        this.progressBar.setVisibility(View.GONE);
        this.message.setText(msg);
        this.message.setVisibility(View.VISIBLE);
        this.actionButton.setText(action);
        this.actionButton.setOnClickListener(listener);
        this.actionButton.setVisibility(View.VISIBLE);
    }

    public void hide() {
        this.setVisibility(View.GONE);
    }



}
