package client;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import entity.Gym;
import entity.Member;
import exception.IdAlreadyPresent;

public class GymApp {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
//		Map<Gym, List<Member>> gymNew = new TreeMap<>(new Comparator<Gym>() {
//
//			@Override
//			public int compare(Gym o1, Gym o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		});
		idInterface idThrow = () -> {
			throw new IdAlreadyPresent("id already present");
		};
		GymApp ob = new GymApp();
		Map<Gym, Set<Member>> gymNew = new TreeMap<>();
		char y = 'y';
		do {
			menu();
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				Set<Member> storeMember = new TreeSet<Member>();
				System.out.println("enter the gym details");
				Gym gym = new Gym();
				System.out.println("enter the id of gym");
				int id = sc.nextInt();
				sc.nextLine();
				id = ob.idCheck(id, gymNew.keySet(), idThrow);
				gym.setId(id);
//				sc.nextLine();
				System.out.println("enter the gym name");
				String name = sc.nextLine();
				gym.setName(name);
				System.out.println("enter the instructor name");
				String instructor = sc.nextLine();
				gym.setInstructorName(instructor);
				int i = 1;
				do {
					System.out.println("enter the member id");
					int memberId = sc.nextInt();
					sc.nextLine();
					memberId = ob.idMemberCheck(memberId, storeMember, idThrow);
					System.out.println("enter the member name");
					String memberName = sc.nextLine();
					System.out.println("enter gender of member");
					System.out.println("1.female 2. male Enter your choice");
					int choice = sc.nextInt();
					char gender = 'a';
					switch (choice) {
					case 1:
						gender = 'f';
						break;
					case 2:
						gender = 'm';
						break;
					default:
						System.out.println("invalid choice");
					}
					System.out.println("enter the member age");
					int memberAge = sc.nextInt();
					Member member = new Member(memberId, memberName, memberAge, gender);
					storeMember.add(member);
					System.out.println("press 1 to continue");
					i = sc.nextInt();
				} while (i == 1);
				gymNew.put(gym, storeMember);
				break;
			case 2:
				long count = 0;
//				for (Integer key : gymData.keySet()) {
//					count = gymData.get(key).getMember().stream().filter(k -> k.getGender() == 'm').count();
//				}				
//				System.out.println("count of all male members " + count);
				Set<Member> member = new HashSet<>();
//				List<Member> maleMember = new ArrayList();
//				Set<Member> maleGymName = new HashSet<>();
//				member.addAll(gymNew.entrySet().stream().map(o->o.getValue()).collect(Collectors.toList()));
				Set<Gym> t = gymNew.keySet();
				for (Gym g : t) {
					count += gymNew.get(g).stream().filter(l -> l.getGender() == 'm').count();
					member = gymNew.get(g).stream().filter(l -> l.getGender() == 'm').collect(Collectors.toSet());
					for (Member maleMember : member) {
						System.out.println("male data " + maleMember + " gym:" + g.getName());
					}
//					maleGymName.add(g.getName());
//					maleMember.addAll(member);
				}
//				int c = 0;
//				Map<String, Member> maleData = new HashMap<>();
//				for (String value : maleGymName) {
//					maleData.put(value, maleMember.get(c++));
//				}
//				System.out.println(maleData);
//				maleData.forEach((x, y1) -> System.out.println(x + " " + y1));
				System.out.println("count of all male members " + count);
				break;
			case 3:
				Set<Member> female = new HashSet<>();
//				List<Member> femaleStore = new ArrayList();
//				for (Integer key : gymData.keySet()) {
//					female.addAll( gymData.get(key).getMember().stream()
//							.filter(g -> (g.getGender() == 'f' && g.getAge() < 25)).collect(Collectors.toList()));
//				}
//
//				female.forEach(x -> System.out.println(x));
//				female.clear();
				Set<Gym> tgym = gymNew.keySet();
				for (Gym g : tgym) {

					female = (gymNew.get(g).stream().filter(k -> (k.getGender() == 'f' && k.getAge() < 25))
							.collect(Collectors.toSet()));

//					femaleStore.addAll(female);
					for (Member femaleMem : female) {
						System.out.println("female data " + femaleMem + " gym:" + g.getName());
					}
				}
//				femaleStore.forEach(x -> System.out.println(x));
				break;

			case 4:
				sc.nextLine();
				int flag = 0;
				System.out.println("enter the gym name to find average age");
				String gymName = sc.nextLine();
//				for (Integer key : gymData.keySet()) {
//					if (gymData.get(key).getName().equals(gymName)) {
//						flag = 1;
//						int sum = gymData.get(key).getMember().stream().map(d -> d.getAge()).reduce(0, (m, n) -> m + n);
//						System.out.println("average of age is " + (sum / gymData.get(key).getMember().size()));
//					}
//				}
//				if (flag == 0)
//					System.out.println("gym not found");
				Set<Gym> togym = gymNew.keySet();
				for (Gym g : togym) {
					if (g.getName().equals(gymName)) {

						flag = 1;
						int sum = gymNew.get(g).stream().map(d -> d.getAge()).reduce((m, n) -> m + n)
								.orElseThrow(() -> new NullPointerException());
						System.out.println("average of age is " + (sum / gymNew.get(g).size()));
					}
				}
				if (flag == 0)
					System.out.println("gym not found");
				flag = 0;
				System.out.println("-------------------");
				System.out.println("for all gym ");
				for (Gym g : togym) {

					int sum = gymNew.get(g).stream().map(d -> d.getAge()).reduce((m, n) -> m + n)
							.orElseThrow(() -> new NullPointerException());
					System.out.println("average of age is " + (sum / gymNew.get(g).size()) + " gym:" + g.getName());

				}

				break;
			case 5:
//				Set<Entry<Integer, Gym>> entrySet=gymData.entrySet();
//				List<Entry<Integer, Gym>> list=new ArrayList(entrySet);
//				Collections.sort(list,new Comparator<Entry<Integer, Gym>>() {
//
//					@Override
//					public int compare(Entry<Integer, Gym> o1, Entry<Integer, Gym> o2) {
//						
//						return o1.getValue().getName().compareTo(o2.getValue().getName());
//					}
//				});

//				Comparator<Member> com = new Comparator<Member>() {
//
//					@Override
//					public int compare(Member c1, Member c2) {
//
//						return c1.getName().compareTo(c2.getName());
//
//					}
//
//				};
//				for(Integer key : gymData.keySet()) {
//					Collections.sort( gymData.get(key).getMember());
//				}
//				Set<Gym> toGgym = gymNew.keySet();
//				for (Gym g : toGgym) {
//					Collections.sort(g.getMember(), com);
//				}
//				System.out.println(gymNew);
				gymNew.forEach((x, y2) -> System.out.println(x+" "+y2));
				break;
			case 6:
				y = 'n';
				break;
			default:
				System.out.println("invalid choice");

			}
		} while (y == 'y');

	}

	private int idCheck(int id, Set<Gym> gym, idInterface idThrow) {
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		do {

			flag = 0;
			try {
				for (Gym gymId : gym) {
					if (id == gymId.getId()) {

						idThrow.message();
					}
				}
			} catch (IdAlreadyPresent e) {
				flag = 1;
				System.out.println("enter id again");
				id = sc.nextInt();
				sc.nextLine();
			}

		} while (flag == 1);
		return id;
	}

	private int idMemberCheck(int id, Set<Member> member, idInterface idThrow) {
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		do {

			flag = 0;
			try {
				for (Member memberId : member) {
					if (id == memberId.getId()) {
						idThrow.message();
					}
				}
			} catch (IdAlreadyPresent e) {
				flag = 1;
				System.out.println("enter id again");
				id = sc.nextInt();
				sc.nextLine();
			}

		} while (flag == 1);
		return id;
	}

	private static void menu() {
		System.out.println("-------------------------");
		System.out.println("1. add gym and members");
		System.out.println("2. show all male members in gym");
		System.out.println("3. show all female members less than 25");
		System.out.println("4. average age of all members for particular gym");
		System.out.println("5. sort all gym and gym members");
		System.out.println("6. exit");
		System.out.println("-------------------------");
		System.out.println("enter your choice");
	}

}

@FunctionalInterface
interface idInterface {
	void message() throws IdAlreadyPresent;
}
