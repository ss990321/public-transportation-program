package publicTransport;

public class Taxi extends Public_Transport {
	
	int taxiMaxP;
	int taxiNumber;
	int defaultTaxiFare = 3000;
	int perDistanceFare = 1000;	
	int defaultDistance = 1;
	boolean taxiStatus;
	String destination;
	int distanceToDestination; 
	int totalIncome;
	int charge = 0;
	
	public static void main(String[] args) {
		Taxi taxi1 = new Taxi();
		Taxi taxi2 = new Taxi();
		taxi1.set_TaxiNumber();
		taxi2.set_TaxiNumber();
		taxi1.setTaxi();
		taxi1.taxi_Board("���￪", 2, 2);
		taxi1.taxi_Refuel(-80);
		taxi1.taxi_Payment();
		taxi1.taxi_Board(null, 0, 5);
		taxi1.taxi_Board("���ε����д�����", 12, 3);
		taxi1.taxi_Refuel(-20);
		taxi1.taxi_Payment();
	}
	
	public void setTaxiMaxP() {
		setMaximumPassenger(4);
		this.taxiMaxP = getMaximumPassenger();
		System.out.println("�ִ� �°� �� : " + taxiMaxP + "��");
	}
	
	public void TaxiCurrentP() {
		System.out.println("���� �°� �� : " + getCurrentPassenger() + "��");		
	}
	 
	public void set_TaxiNumber() {
		this.taxiNumber = (int)(Math.random()*100+1);
		System.out.println("�ý� ��ȣ : "+taxiNumber);
		System.out.println("-----------------------------------");
	}
	
	public void setTaxi() {
		System.out.println("<<" + taxiNumber + "�� �ý�>>");
		setTaxiMaxP();
		TaxiCurrentP();
		System.out.println("������ : " + getCurrentAmountFuel());
		this.taxiStatus = true;
		current_TaxiStatus();
		System.out.println("-----------------------------------");
	}
	
	public void taxi_BoardingStatus() {
		if(this.taxiStatus == false) {
			System.out.println("[ž�ºҰ�]");
		}else {
			System.out.println("[ž�°���]");
		}
	}
	
	public boolean current_TaxiStatus() {
		boolean status = true;
		if(getCurrentPassenger()>0 && fuel_Operability()==true) {
			this.taxiStatus = false;
			System.out.println("���� : ������");
			taxi_BoardingStatus();
			status = false;
		}else if(getCurrentPassenger()==0 && fuel_Operability()==true) {
			this.taxiStatus = true;
			System.out.println("���� : �Ϲ�");
			taxi_BoardingStatus();
			status = true;
		}else if(fuel_Operability()==false) {
			this.taxiStatus = false;
			System.out.println("*���� �ʿ� : ������ �������� ����Ұ�");
			taxi_BoardingStatus();
			status = false;
		}
		return status;
	}
	
	public void taxi_Board(String destination, int distance, int Passenger) {
		System.out.println("<<�°�ž��>>");
		if(current_TaxiStatus() == true) {
			taxi_PassengerInfo(destination, distance, Passenger);
			charge_To_be_Paid(distance);
			if(Passenger<taxiMaxP) {
				System.out.println("�⺻ ��� Ȯ�� : " + defaultTaxiFare + "��");
				System.out.println("������ ��� : " + this.charge +"��");
			}
			current_TaxiStatus();
			System.out.println("-----------------------------------");
		}else {
			current_TaxiStatus();
			System.out.println("-----------------------------------");
		}
		
	}
	
	public void taxi_Payment() {
		System.out.println("<<��ݰ���>>");
		System.out.println("���������� : " + getCurrentAmountFuel());
		taxi_totalIncome();
		setCurrentPassenger(0);
		TaxiCurrentP();
		if(fuel_Operability()==false) {
			this.taxiStatus = false;
			current_TaxiStatus();
		}else {
			this.taxiStatus = true;
			current_TaxiStatus();
		}
		System.out.println("-----------------------------------");
	}
	
	public void  taxi_PassengerInfo(String destination, int distance, int Passenger) {
		boarding_Passenger(Passenger);
		if(Passenger<taxiMaxP) {
			this.destination = destination;
			System.out.println("������ : " + this.destination);
			distanceToDestination = distance;
			System.out.println("������������ �Ÿ� : " + distanceToDestination + "km");
		}
	}
	
	public void charge_To_be_Paid(int distance) {
		int charge = defaultTaxiFare + (distance-1)*perDistanceFare;
		this.totalIncome += charge; 
		this.charge = charge;
	}
	
	public void taxi_totalIncome()  {
		System.out.println("���� ��� : " + totalIncome + "��");
	}
	
	public void taxi_Refuel(int num) {
		System.out.println("<<������ ����>>");
		refuel(num);
		if(fuel_Operability()==false) {
			System.out.println("���������� : " + getCurrentAmountFuel());
			this.taxiStatus = false;
			current_TaxiStatus();
			System.out.println("-----------------------------------");
		}else {
			System.out.println("���������� : " + getCurrentAmountFuel());
			System.out.println("-----------------------------------");
			
		}
	}
	
}
