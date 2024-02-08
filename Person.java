public class Person {

    private int wage;
    private int wealth;
    private boolean thief;
    
    public Person(int wage) {
        this.wage = wage;
        this.thief = false;
        this.wealth = 0;
    }

    public int getWealth() {
        return this.wealth;
    }

    public boolean isThief() {
        return this.thief;
    }

    public void setThief() {
        this.thief = true;
    }

    public void chaseTheBag() {
        this.wealth += this.wage;
    }

    public void getRobbed() {
        this.wealth /= 2;
    }

    public void steal(Person p) {
        this.wealth += (p.getWealth() / 2);
        p.getRobbed();
    }
}
