package kim.nikita.model;

import java.time.LocalDate;

public class Match extends AbstractBaseEntity {

    private Rank rank;

    private MatchType matchType;

    public Match(Rank rank, MatchType matchType, LocalDate date, Hero radiantCarry, Hero radiantMider, Hero radiantOfflaner, Hero radiantSemiSupport, Hero radiantFullSupport, Hero direCarry, Hero direMider, Hero direOfflaner, Hero direSemiSupport, Hero direFullSupport) {
        this.rank = rank;
        this.matchType = matchType;
        this.date = date;
        this.radiantCarry = radiantCarry;
        this.radiantMider = radiantMider;
        this.radiantOfflaner = radiantOfflaner;
        this.radiantSemiSupport = radiantSemiSupport;
        this.radiantFullSupport = radiantFullSupport;
        this.direCarry = direCarry;
        this.direMider = direMider;
        this.direOfflaner = direOfflaner;
        this.direSemiSupport = direSemiSupport;
        this.direFullSupport = direFullSupport;
    }

    public Match(Integer id, Rank rank, MatchType matchType, LocalDate date, Hero radiantCarry, Hero radiantMider, Hero radiantOfflaner, Hero radiantSemiSupport, Hero radiantFullSupport, Hero direCarry, Hero direMider, Hero direOfflaner, Hero direSemiSupport, Hero direFullSupport) {
        super(id);
        this.rank = rank;
        this.matchType = matchType;
        this.date = date;
        this.radiantCarry = radiantCarry;
        this.radiantMider = radiantMider;
        this.radiantOfflaner = radiantOfflaner;
        this.radiantSemiSupport = radiantSemiSupport;
        this.radiantFullSupport = radiantFullSupport;
        this.direCarry = direCarry;
        this.direMider = direMider;
        this.direOfflaner = direOfflaner;
        this.direSemiSupport = direSemiSupport;
        this.direFullSupport = direFullSupport;
    }

    private LocalDate date;

    private Hero radiantCarry;

    private Hero radiantMider;

    private Hero radiantOfflaner;

    private Hero radiantSemiSupport;

    private Hero radiantFullSupport;

    private Hero direCarry;

    private Hero direMider;

    private Hero direOfflaner;

    private Hero direSemiSupport;

    private Hero direFullSupport;


    @Override
    public String toString() {
        return "Match{" +
                "rank=" + rank +
                ", matchType=" + matchType +
                ", date=" + date +
                ", radiantCarry=" + radiantCarry +
                ", radiantMider=" + radiantMider +
                ", radiantOfflaner=" + radiantOfflaner +
                ", radiantSemiSupport=" + radiantSemiSupport +
                ", radiantFullSupport=" + radiantFullSupport +
                ", direCarry=" + direCarry +
                ", direMider=" + direMider +
                ", direOfflaner=" + direOfflaner +
                ", direSemiSupport=" + direSemiSupport +
                ", direFullSupport=" + direFullSupport +
                '}';
    }
}
