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
		taxi1.taxi_Board("서울역", 2, 2);
		taxi1.taxi_Refuel(-80);
		taxi1.taxi_Payment();
		taxi1.taxi_Board(null, 0, 5);
		taxi1.taxi_Board("구로디지털단지역", 12, 3);
		taxi1.taxi_Refuel(-20);
		taxi1.taxi_Payment();
	}
	
	public void setTaxiMaxP() {
		setMaximumPassenger(4);
		this.taxiMaxP = getMaximumPassenger();
		System.out.println("최대 승객 수 : " + taxiMaxP + "명");
	}
	
	public void TaxiCurrentP() {
		System.out.println("현재 승객 수 : " + getCurrentPassenger() + "명");		
	}
	 
	public void set_TaxiNumber() {
		this.taxiNumber = (int)(Math.random()*100+1);
		System.out.println("택시 번호 : "+taxiNumber);
		System.out.println("-----------------------------------");
	}
	
	public void setTaxi() {
		System.out.println("<<" + taxiNumber + "번 택시>>");
		setTaxiMaxP();
		TaxiCurrentP();
		System.out.println("주유량 : " + getCurrentAmountFuel());
		this.taxiStatus = true;
		current_TaxiStatus();
		System.out.println("-----------------------------------");
	}
	
	public void taxi_BoardingStatus() {
		if(this.taxiStatus == false) {
			System.out.println("[탑승불가]");
		}else {
			System.out.println("[탑승가능]");
		}
	}
	
	public boolean current_TaxiStatus() {
		boolean status = true;
		if(getCurrentPassenger()>0 && fuel_Operability()==true) {
			this.taxiStatus = false;
			System.out.println("상태 : 운행중");
			taxi_BoardingStatus();
			status = false;
		}else if(getCurrentPassenger()==0 && fuel_Operability()==true) {
			this.taxiStatus = true;
			System.out.println("상태 : 일반");
			taxi_BoardingStatus();
			status = true;
		}else if(fuel_Operability()==false) {
			this.taxiStatus = false;
			System.out.println("*주유 필요 : 주유량 부족으로 운행불가");
			taxi_BoardingStatus();
			status = false;
		}
		return status;
	}
	
	public void taxi_Board(String destination, int distance, int Passenger) {
		System.out.println("<<승객탑승>>");
		if(current_TaxiStatus() == true) {
			taxi_PassengerInfo(destination, distance, Passenger);
			charge_To_be_Paid(distance);
			if(Passenger<taxiMaxP) {
				System.out.println("기본 요금 확인 : " + defaultTaxiFare + "원");
				System.out.println("지불할 요금 : " + this.charge +"원");
			}
			current_TaxiStatus();
			System.out.println("-----------------------------------");
		}else {
			current_TaxiStatus();
			System.out.println("-----------------------------------");
		}
		
	}
	
	public void taxi_Payment() {
		System.out.println("<<요금결제>>");
		System.out.println("현재주유량 : " + getCurrentAmountFuel());
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
			System.out.println("목적지 : " + this.destination);
			distanceToDestination = distance;
			System.out.println("목적지까지의 거리 : " + distanceToDestination + "km");
		}
	}
	
	public void charge_To_be_Paid(int distance) {
		int charge = defaultTaxiFare + (distance-1)*perDistanceFare;
		this.totalIncome += charge; 
		this.charge = charge;
	}
	
	public void taxi_totalIncome()  {
		System.out.println("누적 요금 : " + totalIncome + "원");
	}
	
	public void taxi_Refuel(int num) {
		System.out.println("<<주유량 변경>>");
		refuel(num);
		if(fuel_Operability()==false) {
			System.out.println("현재주유량 : " + getCurrentAmountFuel());
			this.taxiStatus = false;
			current_TaxiStatus();
			System.out.println("-----------------------------------");
		}else {
			System.out.println("현재주유량 : " + getCurrentAmountFuel());
			System.out.println("-----------------------------------");
			
		}
	}
	
}
