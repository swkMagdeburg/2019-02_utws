package gov.federation;

import java.util.stream.Collectors;

public class Enterprise
{
    private WarpCore core;
    private Captn captn = new JeanLuc();

    Enterprise(WarpCore core) {
        if(core == null)
            throw new IllegalStateException("No Core no fly Cap!");
        this.core = core;
        core.registerMonitoring( (state) -> { if(state == WarpCore.State.CRITICAL) disasterCoreRelease(); } );
    }

    public void increaseSpeed() {
        core.moreJuice();
    }

    public void loadPulseCanon() {
        core.moreJuice();
    }

    public void watchFuturamaEpisodeOnBridge() {
        core.cooldown(); // no extra power needed for this
    }

    public void hideBakuOnHolodeck(){
        // this needs much power
        core.moreJuice();
        core.moreJuice();
    }

    public void fireTorpedo() {
        if(!captnOnBridge())
            throw new IllegalStateException("Cap'n on Bridge required to fire a torpedo!");

        System.out.println("Boom");
    }

    void setInterimCaptn(Captn riker){
        this.captn = riker;
    }

    private boolean captnOnBridge()
    {
        return this.captn.getLocation() == Captn.Location.Bridge;
    }

    public Replicator.Replication replicateMeARomulanAle(){
        final Replicator replicator = Replicator.get();
        final Replicator.Replication romulaneAle = replicator.scriptedReplication("Romulane Ale")
                .with("1 oz Navy-strength gin")
                .with("1 1⁄2 oz Blue curaçao")
                .with("3⁄4 oz Fresh lemon juice")
                .with("1⁄2 oz Simple syrup")
                .with("1 Egg white")
                .with("2 oz Tonic water")
                .with("4 drops Orange blossom water")
                .replicate();
        System.out.println("Enjoy your "+romulaneAle.getName()+" consisting of:\n"+
                romulaneAle.getIngredients().stream().collect(Collectors.joining("\n")));
        return romulaneAle;
    }

    private void disasterCoreRelease() {
        System.out.println("EEEEEEJJJJJEEEEECCCTTT");
        core = null;
    }
}
