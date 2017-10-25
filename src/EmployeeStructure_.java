/*
    * This program aim to show
    * The relationship between a sub class from its parent class
    * The way in which Objct Orientation Principles works
    @param prints name of a person together its lastname as a String
    @author Gcobani Mkontwan.
    @date 11 October 2017
*/



import java.util.*;

/*
   * Hyrical relationship between sub-class and parent class.
    *@param returns an Arraylist as a type.
*/
class EmployeeStructure_{
	 static class Employee {
		private String name;
		public ArrayList<Employee> subs;

		public Employee(String n){
			this.name = n;
			subs = new ArrayList<Employee>();
		}

		public void printSubs(){
			for(Employee e : this.subs) {
				System.out.print(e + ", ");
				e.printSubs();
			}
		}

		public String toString(){
			return this.name;
		}

	}

	public static void main(String[] args) {
		HashMap<String, Employee> employees = new HashMap<String, Employee>();
		Employee joe = new Employee("Joe");
		Employee mary = new Employee("Mary");
		Employee alfonse = new Employee("Alfonse");
		Employee harry = new Employee("Harry");
		Employee chang = new Employee("Chang");
		
		mary.subs.add(alfonse);
		harry.subs.add(chang);
		harry.subs.add(mary);
		joe.subs.add(harry);
		
		employees.put("joe", joe);
		employees.put("mary", mary);
		employees.put("alfonse", alfonse);
		employees.put("harry", harry);
		employees.put("chang", chang);	
		Scanner input = new Scanner(System.in);

		while(true){
			String name = input.nextLine();
			Employee emp = (Employee)employees.get(name.toLowerCase());
			if (emp != null) {
				emp.printSubs();
				System.out.println();
			}else{
				System.out.println("No employee with name: " + name + " was found");
			}
		}

	}
}