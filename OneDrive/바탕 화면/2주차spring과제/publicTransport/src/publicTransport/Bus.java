
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
		System.out.println("�ִ� �°� �� : " + busMaxP + "��");
	}
	
	public void BusCurrentP() {
		System.out.println("���� �°� �� : " + getCurrentPassenger() + "��");		
	}
	
	public void set_BusNumber() {
		this.busNumber = (int)(Math.random()*100+1);
		System.out.println("���� ��ȣ : "+busNumber);
		System.out.println("-----------------------------------");
	}

	public void setBus() {
		System.out.println(busNumber + "�� ����");
		this.busStatus = true;
		System.out.println("���� : ����");
		setBusMaxP();
		BusCurrentP();
		System.out.println("��� : " + busFare + "��");
		System.out.println("������ : " + getCurrentAmountFuel());
		System.out.println("���� �ӵ� : " + getCurrentSpeed());
		System.out.println("-----------------------------------");
	}
	
	public void change_busStatus(boolean status) {
		System.out.println("<<���ຯ��>>");
		if(status == true) {
			this.busStatus = true;
			System.out.println("�������� ����Ǿ����ϴ�.");
			System.out.println("-----------------------------------");
			current_busStatus();
		}else {
			this.busStatus = false;
			System.out.println("������������ ����Ǿ����ϴ�.");
			System.out.println("-----------------------------------");
			setCurrentPassenger(0);
			setCurrentSpeed(0);
			current_busStatus();
		}

	}
	
	public void bus_totalIncome()  {
		totalIncome += getCurrentPassenger();
		System.out.println("�� ���� : " + (busFare*totalIncome) + "��");
	}
	
	public void current_busStatus() {
		System.out.println("<<���� �������>>");
		if(this.busStatus == true) {
			System.out.println("���� : ����");
			BusCurrentP();
			bus_totalIncome();	
			System.out.println("���� �ӵ� : " + getCurrentSpeed());
		}
		else {
			System.out.println("���� : ��������");
		}
		
		System.out.println("���������� : " + getCurrentAmountFuel());
		
		if(fuel_Operability()==false)
			System.out.println("������ �ʿ��մϴ�.");
		
		System.out.println("-----------------------------------");
	}
	
	public void bus_Refuel(int num) {
		System.out.println("<<������ ����>>");
		refuel(num);
		if(fuel_Operability()==false) {
			System.out.println("���������� : " + getCurrentAmountFuel());
			System.out.println("������ �������� ������������ ����˴ϴ�.");
			System.out.println("-----------------------------------");
			change_busStatus(false);
		}else {
			System.out.println("���������� : " + getCurrentAmountFuel());
			System.out.println("-----------------------------------");
			
		}
	}


	// �°� ž��
	public void bus_Board(int Passenger) {
		System.out.println("<<�°�ž��>>");
		if(busStatus==true) {
			boarding_Passenger(Passenger);
			System.out.println("��� : " + busFare + "��");
			System.out.println("������� : " + busFare*getCurrentPassenger() + "��");
			bus_totalIncome();
			System.out.println("-----------------------------------");
		}else {
			System.out.println("�������� �ƴϹǷ� �°��� ž���� �� �����ϴ�.");
		}
	}


	public void change_BusSpeed(int speed) {
		System.out.println("<<�ӵ�����>>");

		if(fuel_Operability()==true) {
			System.out.println("���� �ӵ� : " + getCurrentSpeed());
			change_Speed(speed);	
			System.out.println("����� �ӵ� : " + getCurrentSpeed());
			System.out.println("-----------------------------------");
		}else {
			System.out.println("�������� Ȯ�����ּ���. �������� 10 �̻��̾�� �ӵ��� ����˴ϴ�.");
			System.out.println("������ : " + getCurrentAmountFuel());
			System.out.println("���� �ӵ� : " + getCurrentSpeed());
			System.out.println("-----------------------------------");
		}

	}
	

}