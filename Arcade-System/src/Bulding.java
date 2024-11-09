import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Bulding {

	private Owner owner;
	private String name;
	private ArrayList<Room> rooms;
	private ArrayList<Workrs> workers;
	private ArrayList<Players> players;
	private int buldingID;
	static int lastbuldingID=0;
	
	 public Bulding() {
		 
	 }
	 
	public Bulding(String name) {
		this.rooms = new ArrayList<>();
		this.workers = new ArrayList<>();
		this.players = new ArrayList<>();
		setName(name);
		setbuldingID();
		
	}
			
	public void PrintBInfo() {
		if (owner.getBuldings().get(GUI.numofbulding.getSelectedIndex()).getRooms().isEmpty()) {
			JOptionPane.showMessageDialog(null, "there is no rooms in this buliding");
		} else {
			StringBuilder message = new StringBuilder(owner.getBuldings().get(GUI.numofbulding.getSelectedIndex()).getName()+" Building info:\n\n");

			for (Room room : getRooms()) {
				message.append("Room Name: ").append(room.getName()).append("\n");
				message.append("Price per Hour: $").append(room.getPricePerHour()).append("\n\n");
			}

			JOptionPane.showMessageDialog(null, message.toString());
		}
	}
	
	public void PrintWinfo() {
		if (owner.getBuldings().get(GUI.wbuild.getSelectedIndex()).getWorkers().isEmpty()) {
			JOptionPane.showMessageDialog(null, "there is no Workers in this buliding");
		} else {
			StringBuilder message = new StringBuilder(owner.getBuldings().get(GUI.wbuild.getSelectedIndex()).getName()+" Building info:\n\n");

			for (Workrs workrs : getWorkers()) {
				message.append("Worker Name: ").append(workrs.getName()).append("\n");
				message.append("Worker Age:").append(workrs.getAge()).append("\n\n");
				message.append("Worker Phone number:").append(workrs.getPhonenumber()).append("\n\n");
				message.append("Worker Gender:").append(workrs.getGender()).append("\n\n");
				message.append("Worker Job:").append(workrs.getJob()).append("\n\n");
				message.append("Worker Work Hours:").append(workrs.getWorkhours()).append("\n\n");
				message.append("Worker Salary:").append(workrs.getSalary()).append("\n\n");
				message.append("Worker ID:").append(workrs.getID()).append("\n\n");
			}

			JOptionPane.showMessageDialog(null, message.toString());
		}
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Owner getOwner() {
		return owner;
	}

	public void addRoom(Room room) {
		this.rooms.add(room);
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void addWorker(Workrs worker) {
		this.workers.add(worker);
	}

	public ArrayList<Workrs> getWorkers() {
		return workers;
	}

	public void addPlayer(Players player) {
		this.players.add(player);
	}

	public ArrayList<Players> getPlayers() {
		return players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setbuldingID() {
		this.buldingID = ++lastbuldingID;
	}
	public int getbuldingID() {
		return buldingID;
	}

	public int getNumofactive() {
		int numofactive=0;
		for(int i=0; i<workers.size(); i++) {
			if(workers.get(i).getStatus()==true) {
				numofactive++;
			}
		}
		return numofactive;
	}

	public int getNumofinactive() {
		int numofinactive=0;
		for(int i=0; i<workers.size(); i++) {
			if(workers.get(i).getStatus()==false) {
				numofinactive++;
			}
		}
		return numofinactive;
	}
	public int getnumoftc() {
		int tcnum=0;
		for(int i=0; i<workers.size(); i++) {
			if(workers.get(i).getJob()=="Technation") {
				tcnum++;
			}
		}
		return tcnum;
	}
	public int getnumofma() {
		int manum=0;
		for(int i=0; i<workers.size(); i++) {
			if(workers.get(i).getJob()=="Manegar") {
				manum++;
			}
		}
		return manum;
	}
	public int getnumofca() {
		int canum=0;
		for(int i=0; i<workers.size(); i++) {
			if(workers.get(i).getJob()=="Cleaner") {
				canum++;
			}
		}
		return canum;
	}
	public int getnumPc() {
		int numPc=0;
		for(int i=0; i<players.size(); i++) {
			if(players.get(i).getInroom()=="console Room") {
				numPc++;
			}
		}
		return numPc;
	}
	public int getnumofPv() {
		int numofPv=0;
		for(int i=0; i<players.size(); i++) {
			if(players.get(i).getInroom()=="VR Room") {
				numofPv++;
			}
		}
		return numofPv;
	}
	public int getnumofPp() {
		int numofPp=0;
		for(int i=0; i<players.size(); i++) {
			if(players.get(i).getInroom()=="PC Room") {
				numofPp++;
			}
		}
		return numofPp;
	}
}