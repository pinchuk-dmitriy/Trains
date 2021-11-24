package pinchuk.dmitriy.issoft.domain.users;

public class Driver extends User {

    public static final int MIN_AGE_OF_DRIVER = 18;

    private boolean isLicensed;

    public Driver(String username, boolean isLicensed) {

        super(username);
        this.isLicensed = isLicensed;

    }

    public Driver(String username, String firstName, String lastName, boolean isLicensed) {

        super(username, firstName, lastName);
        this.isLicensed = isLicensed;

    }

    @Override
    public void setAge(int age) {

        if(age >= MIN_AGE_OF_DRIVER) {

            super.setAge(age);

        } else {

            throw new IllegalArgumentException("Driver cannot be under the age of 18");

        }
    }

    public boolean isHaveLicense() {
        return isLicensed;
    }

    public void setLicensed(boolean isLicensed) {
        this.isLicensed = isLicensed;
    }
}
