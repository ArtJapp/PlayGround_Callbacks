package mrth.chronicker.playground.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import mrth.chronicker.playground.R;
import mrth.chronicker.playground.models.Message;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MessageViewHolder> {

    private List<Message> messages;
    private MessageCallBack callBack;

    public MainListAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int index) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message, viewGroup, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int index) {
        Message message = messages.get(index);
        messageViewHolder.setMessageData(message.getId(), message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messages == null ? 0 : messages.size();
    }

    public void setCallBack(MessageCallBack callBack) {
        this.callBack = callBack;
    }

    public interface MessageCallBack {
        void onMessageClicked(int id, String message);
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        private int messageId;
        private String messageBody;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setMessageData(int messageId, String data) {
            this.messageId = messageId;
            messageBody = data;
        }

        @OnClick(R.id.rootMessageView)
        public void onItemClick(View view) {
            callBack.onMessageClicked(messageId, messageBody);
        }
    }
}
