package gov.federation;

public class JeanLuc implements Captn
{

    @Override
    public Location getLocation()
    {
        throw new IllegalStateException("This Cap'n is on vacation");
    }
}
