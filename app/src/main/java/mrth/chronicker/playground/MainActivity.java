package mrth.chronicker.playground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.chronicker.playground.adapters.MainListAdapter;
import mrth.chronicker.playground.models.Message;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.rvListOfItems)
    RecyclerView rvMessages;
    @BindView(R.id.linLay)
    LinearLayout linLay;
    @BindView(R.id.tvMessageID)
    TextView tvMessageId;
    @BindView(R.id.tvMessageBody)
    TextView tvMessageBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        rvMessages.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvMessages.setNestedScrollingEnabled(false);

        MainListAdapter adapter = new MainListAdapter(generateMessages(10));
        try {
            adapter.setCallBack((MainListAdapter.MessageCallBack) this);
        } catch (ClassCastException ex) {
            Toast.makeText(this, "Sorry, кина не будет", Toast.LENGTH_SHORT).show();
            return;
        }

        rvMessages.setAdapter(adapter);
    }

    private List<Message> generateMessages(int count) {
        ArrayList<Message> messages = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            messages.add(new Message(index, "Generated message " + String.valueOf(index)));
        }
        return messages;
    }

    @Override
    public void onMessageClicked(int id, String message) {
        linLay.setVisibility(View.VISIBLE);
        tvMessageId.setText(getResources().getString(R.string.help_text) + String.valueOf(id));
        tvMessageBody.setText(getResources().getString(R.string.body) + "\"" + message + "\"");
    }
}
