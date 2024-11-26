package DailyPratice.LAMBAEXPRESSIONS;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.ForkJoinTask;

public class MyRecursiveTask extends ForkJoinTask<T> {
    public MyRecursiveTask(int i, int i1) {
    }

    @Override
    public T getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(T value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }
}
