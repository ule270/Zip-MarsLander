public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) {
        int burn = 0;
        int Altitude = status.getAltitude();
        int Velocity = status.getVelocity();
        if(Altitude > 1000){
            burn = getToOneThousandAlt(status);
        } else {
            burn = subOneThousand(status);
        }
        System.out.println(burn); /*hack!*/
        return burn;
    }

    public int getToOneThousandAlt(DescentEvent status){
        int Altitude = status.getAltitude();
        if (Altitude > 1500 && Altitude <7000){
//            return burn = 0; since you are still accelerating at 1000;
//            altitude decreasing by 1000;
            return 200;
        } else if (Altitude <= 1500){
//            return burn = 100; so you start decelerating;
//            does not decelerate or accelerate at same rate so accounts for
//            500 leftover;
            return 100;
        }
        return 100;
    }

    public int subOneThousand(DescentEvent status) {
        int Altitude = status.getAltitude();
        int burn = 0;
        if (Altitude > 200) {
//            return burn = 100 to continue going at 100m/s with DeltaV=0;
            burn = 100;
        } else if (Altitude == 200) {
//            burn at 175 will decelerate to 25 m/s;
            burn = 175;
        } else if (Altitude > 50 && Altitude <200){
//            keep velocity at 25m/s so burn at 100;
            burn = 100;
        } else if (Altitude == 50) {
//            burn at 115 will have DeltaV of -15 so going at 10m/s;
            burn = 115;
        } else if (Altitude <50 && Altitude > 10){
            burn = 100;
        } else if (Altitude == 10) {
//            burn at 108 will have DeltaV of -8 so going at 2m/s;
            burn = 108;
        } else {
            burn = 100;
        }
        return burn;
    }
}
