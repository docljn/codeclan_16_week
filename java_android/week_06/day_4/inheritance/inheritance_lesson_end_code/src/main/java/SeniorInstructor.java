public class SeniorInstructor extends Instructor {

  private String favouriteHat;

  public SeniorInstructor(String name, String cohort, String moduleTeam, String favouriteHat) {
    super(name, cohort, moduleTeam);
    this.favouriteHat = favouriteHat;
  }
}
