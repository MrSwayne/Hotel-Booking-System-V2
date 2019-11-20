package ie.ul.hbs2.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private static CareTaker instance;
    public static synchronized CareTaker getInstance(){
        if(instance==null){
            instance = new CareTaker();
        }
        return instance;
    }
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int n){
        Memento x;
        int size = mementoList.size();
        x = mementoList.get(mementoList.size() - n);
        for (int i = 1;i<size;i++){
            mementoList.remove(mementoList.size()-i); }
        return (x);
    }
}