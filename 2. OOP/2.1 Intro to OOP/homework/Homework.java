package homework;

public class Homework {

	public static void main(String[] args) {
		
		Computer first = new Computer();
		Computer second = new Computer();
		Computer third = new Computer();
		Computer fourth = new Computer();
		Computer fifth = new Computer();
		
		Computer[] computers = new Computer[5];
		
		computers[0] = first;
		computers[1] = second;
		computers[2] = third;
		computers[3] = fourth;
		computers[4] = fifth;

		first.processor = "Intel Core";
		first.clockRate = 9;
		first.memory = 4;
		
		second.processor = "Pentium";
		second.clockRate = 3.50;
		second.memory = 8;
		
		third.processor = "Altair";
		third.clockRate = 2;
		third.memory = 2;
		
		fourth.processor = "Celeron";
		fourth.clockRate = 3.30;
		fourth.memory = 16;
		
		fifth.processor = "AMD";
		fifth.clockRate = 8.40;
		fifth.memory = 32;
		
		for (int i = 0; i < computers.length; i++) {
            computers[i].perfIndexCalc();
        }

        for (int i = 0; i < computers.length - 1; i++) {
            for (int j = 0; j < computers.length - 1; j++) {
                if (computers[j].perfIndex < computers[j + 1].perfIndex) {
                    Computer temp = computers[j];
                    computers[j] = computers[j + 1];
                    computers[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < computers.length; i++) {
            computers[i].printIndex();
        }
	}

}
