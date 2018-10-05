package mrth.chronicker.playground;

import mrth.chronicker.playground.adapters.MainListAdapter;

public interface MainView extends MainListAdapter.MessageCallBack {
    // по большей части, этот интерфейс нужен для того, чтобы не городить огромный список всех заимплеменченных коллбэков в активити
}
