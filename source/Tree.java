import java.util.ArrayList;
import java.util.List;

// Represents a tree and controls its current state.
public class Tree {

    private TreeState state;
    private final List<TreeState> stateHistory;

    public Tree() {
        state = TreeState.GREEN;
        stateHistory = new ArrayList<>();
        stateHistory.add(state);
    }

    public void burn() {
        changeState(TreeState.BURNING);
    }

    public void extinguish() {
        changeState(TreeState.BURNED);
    }

    public void regrow() {
        changeState(TreeState.GREEN);
    }

    private void changeState(TreeState newState) {
        if (state.canTransitionTo(newState)) {
            state = newState;
            stateHistory.add(state);
        }
    }

    public boolean isGreen() {
        return state == TreeState.GREEN;
    }

    public boolean isBurning() {
        return state == TreeState.BURNING;
    }

    public boolean isBurned() {
        return state == TreeState.BURNED;
    }

    public TreeState getState() {
        return state;
    }

    public List<TreeState> getStateHistory() {
        return new ArrayList<>(stateHistory);
    }
}