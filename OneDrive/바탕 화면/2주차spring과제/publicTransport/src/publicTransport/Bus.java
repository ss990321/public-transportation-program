
package publicTransport;

public class Bus extends Public_Transport {

	int busMaxP;
	int busNumber;
	int busFare = 1000;
	int totalIncome = 0;
	boolean busStatus;
	
	public static void main(String[] args) {
		Bus bus1 = new Bus();
		Bus bus2 = new Bus();
		bus1.set_BusNumber();
		bus2.set_BusNumber();
		bus1.setBus();
		bus1.bus_Board(2);
		bus1.bus_Refuel(-50);
		bus1.change_busStatus(false);
		bus1.bus_Refuel(+10);
		bus1.current_busStatus();
		bus1.change_busStatus(true);
		bus1.bus_Board(45);
		bus1.bus_Board(5);
		bus1.bus_Refuel(-55);
	}
	
	public void setBusMaxP() {
		setMaximumPassenger(30);
		this.busMaxP = getMaximumPassenger();
		System.out.println("최대 승객 수 : " + busMaxP + "명");
	}
	
	public void BusCurrentP() {
		System.out.println("현재 승객 수 : " + getCurrentPassenger() + "명");		
	}
	
	public void set_BusNumber() {
		this.busNumber = (int)(Math.random()*100+1);
		System.out.println("버스 번호 : "+busNumber);
		System.out.println("-----------------------------------");
	}

	public void setBus() {
		System.out.println(busNumber + "번 버스");
		this.busStatus = true;
		System.out.println("상태 : 운행");
		setBusMaxP();
		BusCurrentP();
		System.out.println("요금 : " + busFare + "원");
		System.out.println("주유량 : " + getCurrentAmountFuel());
		System.out.println("현재 속도 : " + getCurrentSpeed());
		System.out.println("-----------------------------------");
	}
	
	public void change_busStatus(boolean status) {
		System.out.println("<<운행변경>>");
		if(status == true) {
			this.busStatus = true;
			System.out.println("운행으로 변경되었습니다.");
			System.out.println("-----------------------------------");
			current_busStatus();
		}else {
			this.busStatus = false;
			System.out.println("차고지행으로 변경되었습니다.");
			System.out.println("-----------------------------------");
			setCurrentPassenger(0);
			setCurrentSpeed(0);
			current_busStatus();
		}

	}
	
	public void bus_totalIncome()  {
		totalIncome += getCurrentPassenger();
		System.out.println("총 수입 : " + (busFare*totalIncome) + "원");
	}
	
	public void current_busStatus() {
		System.out.println("<<현재 운행상태>>");
		if(this.busStatus == true) {
			System.out.println("상태 : 운행");
			BusCurrentP();
			bus_totalIncome();	
			System.out.println("현재 속도 : " + getCurrentSpeed());
		}
		else {
			System.out.println("상태 : 차고지행");
		}
		
		System.out.println("현재주유량 : " + getCurrentAmountFuel());
		
		if(fuel_Operability()==false)
			System.out.println("주유가 필요합니다.");
		
		System.out.println("-----------------------------------");
	}
	
	public void bus_Refuel(int num) {
		System.out.println("<<주유량 변경>>");
		refuel(num);
		if(fuel_Operability()==false) {
			System.out.println("현재주유량 : " + getCurrentAmountFuel());
			System.out.println("주유량 부족으로 차고지행으로 변경됩니다.");
			System.out.println("-----------------------------------");
			change_busStatus(false);
		}else {
			System.out.println("현재주유량 : " + getCurrentAmountFuel());
			System.out.println("-----------------------------------");
			
		}
	}


	// 승객 탑승
	public void bus_Board(int Passenger) {
		System.out.println("<<승객탑승>>");
		if(busStatus==true) {
			boarding_Passenger(Passenger);
			System.out.println("요금 : " + busFare + "원");
			System.out.println("현재수입 : " + busFare*getCurrentPassenger() + "원");
			bus_totalIncome();
			System.out.println("-----------------------------------");
		}else {
			System.out.println("운행중이 아니므로 승객이 탑승할 수 없습니다.");
		}
	}


	public void change_BusSpeed(int speed) {
		System.out.println("<<속도변경>>");

		if(fuel_Operability()==true) {
			System.out.println("이전 속도 : " + getCurrentSpeed());
			change_Speed(speed);	
			System.out.println("변경된 속도 : " + getCurrentSpeed());
			System.out.println("-----------------------------------");
		}else {
			System.out.println("주유량을 확인해주세요. 주유량이 10 이상이어야 속도가 변경됩니다.");
			System.out.println("주유량 : " + getCurrentAmountFuel());
			System.out.println("현재 속도 : " + getCurrentSpeed());
			System.out.println("-----------------------------------");
		}

	}
	

}