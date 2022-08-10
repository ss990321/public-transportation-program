package publicTransport;

public class Public_Transport {

	private int Number;
	private int maximumPassenger;
	private int currentPassenger;
	private int currentAmountFuel = 100;
	private int currentSpeed = 0;

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public int getMaximumPassenger() {
		return maximumPassenger;
	}

	public void setMaximumPassenger(int maximumPassenger) {
		this.maximumPassenger = maximumPassenger;
	}

	public int getCurrentPassenger() {
		return currentPassenger;
	}

	public void setCurrentPassenger(int currentPassenger) {
		this.currentPassenger = currentPassenger;
	}

	public int getCurrentAmountFuel() {
		return currentAmountFuel;
	}

	public void setCurrentAmountFuel(int currentAmountFuel) {
		this.currentAmountFuel = currentAmountFuel;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public boolean fuel_Operability() {
		if (getCurrentAmountFuel() < 10) return false;
		else return true;
	}
	

	public boolean status() {
		if (fuel_Operability() == true)
			return true;
		else {
			setCurrentPassenger(0);
			return false;
		}
	}

	public int refuel(int fuel) { 
		int sum = getCurrentAmountFuel();
		sum += fuel;
		setCurrentAmountFuel(sum);
		return getCurrentAmountFuel(); 
	}

	public int change_Speed(int speed) { 
		int sum = getCurrentSpeed();
		sum += speed;
		setCurrentSpeed(sum);
		return getCurrentSpeed();
	}

	public int boarding_Passenger(int num) {
		int sum = getCurrentPassenger();
		sum += num;
		setCurrentPassenger(sum);
		if(passenger_Operability()==true) {
			System.out.print("ž�� �°� �� : " + getCurrentPassenger() + "��\n�ܿ� �°� �� : ");
			System.out.println(getMaximumPassenger()-getCurrentPassenger() + "��");
			return getCurrentPassenger();
		}else {
			setCurrentPassenger(sum-num);
			System.out.println("�ִ� �°� ���� �ʰ��߽��ϴ�.");
			System.out.println(getMaximumPassenger()-getCurrentPassenger() + "�� �̻� ž���� �� �����ϴ�.");
			System.out.println("���� �°� �� : " + getCurrentPassenger() + "��");
			return getCurrentPassenger();
		}
	}

	public boolean passenger_Operability() {
		if(getCurrentPassenger() <= getMaximumPassenger()) return true;
		else return false;
	}
}
