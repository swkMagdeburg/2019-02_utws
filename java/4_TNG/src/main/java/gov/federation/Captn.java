package gov.federation;

import javax.xml.stream.Location;

public interface Captn
{
    enum Location{ Bridge, CrewDeck, Engineering }

    Location getLocation();
}
