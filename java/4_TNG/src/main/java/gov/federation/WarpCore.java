package gov.federation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class WarpCore
{
    enum State { OFF, NORMAL, OVERHEATING, CRITICAL }
    private State currentState = State.OFF;

    private List<Consumer<State>> monitoring = new ArrayList<>();

    void registerMonitoring(Consumer<State> listener)
    {
        monitoring.add(listener);
    }

    void moreJuice() {
        if(currentState == State.CRITICAL)
            throw new ReactorMeltdownException("Congratulations Capt'n! You killed you're whole crew!");
        currentState = State.values()[currentState.ordinal()+1];
    }

    void cooldown() {
        if(currentState == State.OFF)
            return;
        currentState = State.values()[currentState.ordinal()-1];
    }

    public State getCurrentState()
    {
        return currentState;
    }

    class ReactorMeltdownException extends RuntimeException{
        ReactorMeltdownException(String message)
        {
            super(message);
        }
    }
}
