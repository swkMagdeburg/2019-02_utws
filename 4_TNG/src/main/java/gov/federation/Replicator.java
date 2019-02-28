package gov.federation;

import java.util.ArrayList;
import java.util.List;

public class Replicator
{
    private Replicator() {}
    static Replicator get() {
        throw new RuntimeException("I'm broken");
        //return new Replicator();
    }

    static class Replication {
        private final List<String> ingredients = new ArrayList<>();
        private final String name;

        public Replication(String name)
        {
            this.name = name;
        }

        public void put(String ingredient)
        {
            ingredients.add(ingredient);
        }

        public String getName()
        {
            return name;
        }

        public List<String> getIngredients()
        {
            return new ArrayList<>(ingredients);
        }
    }

    static class RepBuilder {
        final Replication rep;
        RepBuilder(String name) {
            rep = new Replication(name);
        }
        RepBuilder with(String ingredient) {
            rep.put(ingredient);
            return this;
        }
        Replication replicate() {
            return rep;
        }

    }

    public RepBuilder scriptedReplication(String name)
    {
        return new RepBuilder(name);
    }

}
