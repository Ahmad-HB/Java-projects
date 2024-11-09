import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI {
	// declare variables
	static int c = 0, c2 = 0, c3 = 0;
	static JTextField t1;
	static JPasswordField p1;
	static JLabel NOB, l4, Photo, Ownername, name, phonenum, sector, Name, Phonenum, age, Age, buid, numofbuild, price,
			typeofroom, LNOB, numofroom, LNOR, lWname, lwage, lwph, lwhours, lwbuild, ljob, lwsalary, lgender, NUMofTC,
			NUMofMA, NUMofC, numOFactive, numOFinactive, TCnum, MAnum, Cnum, active, inactive, lpph, lpage, lpname,
			lscbp, lscrp, lnumofP, lnumofPp, lnumofPv, lnumPc, numofP, numofPinp, numofPinv, numofPinc;
	static JPanel panel;
	static JFrame win, win2, win3, win4;
	static String r, numofB[], jobs[], genders[], rooms[];
	// static ArrayList<String> numofB=new ArrayList<>();
	static Owner owner = new Owner();
	static JTextField priceofroom, nameofB, wnametxt, wagetxt, wphtxt, whourstxt, wsalarytxt, pagetxt, pnametxt, pphtxt;
	static JButton Addroom, edit, Addb, Show, addw, wshow, Finishbt, addp;
	static JComboBox roomtype, numofbulding, wbuild, job, gender, SHB, SHW, scrp, scbp;

	// method for the Arcade Manager system
	
	public static void System() {

		// initializing a frame for the system
		win2 = new JFrame("Arcade Manager");
		win2.setSize(400, 300);
		win2.setLocationRelativeTo(null);
		win2.getContentPane().setLayout(null);
		win2.setVisible(false);
		win2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		win4 = new JFrame("Worker Details");
		win4.setVisible(false);
		win4.setSize(315, 360);
		win4.getContentPane().setLayout(null);

		// button to show the info of the rooms inside the building
		Show = new JButton("Show info");
		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					owner.getBuldings().get(numofbulding.getSelectedIndex()).PrintBInfo();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "there is no rooms");
				}
			}
		});
		Show.setVisible(false);
		Show.setBounds(5, 237, 195, 30);
		win2.getContentPane().add(Show);

		// numofbulding.addItem(numofB);
		numofbulding = new JComboBox();
		numofbulding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LNOR.setText(
						(Integer.toString(owner.getBuldings().get(numofbulding.getSelectedIndex()).getRooms().size())));
			}
		});
		numofbulding.setBounds(245, 55, 150, 27);
		numofbulding.setVisible(false);
		win2.getContentPane().add(numofbulding);

		SHW = new JComboBox();
		SHW.setBounds(5, 25, 305, 30);
		SHW.setVisible(false);
		win4.getContentPane().add(SHW);

		/*
		SHB = new JComboBox();
		SHB.setVisible(false);
		SHB.setBounds(5, 25, 150, 30);
		win4.add(SHB);
		*/

		// button to add new building to the owner
		Addb = new JButton("ADD Building");
		Addb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				owner.addBulding(new Bulding(nameofB.getText()));
				numofbuild.setText(String.valueOf(owner.numofbuldings()));
				numofB = new String[owner.numofbuldings()];
				numofB[c] = owner.getBuldings().get(c).getName();
				numofbulding.addItem(owner.getBuldings().get(c).getName()+":"+owner.getBuldings().get(c).getbuldingID());
				wbuild.addItem(owner.getBuldings().get(c).getName()+":"+owner.getBuldings().get(c).getbuldingID());
				//SHB.addItem(owner.getBuldings().get(c).getName());
				scbp.addItem(owner.getBuldings().get(c).getName()+":"+owner.getBuldings().get(c).getbuldingID());
				c++;
				/*
				 * numofbulding.addItem(numofB); for (int i = 0; i < owner.numofbuldings(); i++)
				 * { numofbulding.addItem(owner.getBuldings().get(i).getName()); }
				 * 
				 * 
				 * owner.addBulding(new Bulding(nameofB.getText()));
				 * numofbuild.setText(String.valueOf(owner.numofbuldings())); numofB=new
				 * String[owner.numofbuldings()];
				 * numofB[c]=owner.getBuldings().get(c).getName(); c++;
				 * numofbulding.addItem(numofB); for (int i = 0; i < numofB.length; i++) {
				 * numofB[c]=nameofB.getText(); c++;
				 * //numofB.add(owner.getBuldings().get(i).getName()); }
				 */

			}
		});
		Addb.setBounds(125, 237, 150, 30);
		win2.getContentPane().add(Addb);

		// numofB=new String[owner.numofbuldings()];

		// initializing text field
		nameofB = new JTextField();
		nameofB.setBounds(245, 55, 150, 27);
		win2.getContentPane().add(nameofB);

		// initializing label
		NOB = new JLabel("name of the building:");
		NOB.setBounds(101, 59, 140, 16);
		win2.getContentPane().add(NOB);

		// initializing text field
		priceofroom = new JTextField();
		priceofroom.setBounds(245, 133, 150, 30);
		priceofroom.setVisible(false);
		win2.getContentPane().add(priceofroom);

		// initializing label
		price = new JLabel("Price per hour:");
		price.setBounds(146, 140, 95, 16);
		price.setVisible(false);
		win2.getContentPane().add(price);

		// button to add new rooms to the building
		Addroom = new JButton("ADD Room");
		Addroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					owner.getBuldings().get(numofbulding.getSelectedIndex())
							.addRoom(new Room(r, Double.valueOf(priceofroom.getText())));
					// building.addRoom(new Room(r, Double.valueOf(priceofroom.getText())));
					LNOR.setText((Integer
							.toString(owner.getBuldings().get(numofbulding.getSelectedIndex()).getRooms().size())));

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "there is no building to add rooms");

				}
			}
		});

		Addroom.setBounds(200, 237, 195, 30);
		Addroom.setVisible(false);
		win2.getContentPane().add(Addroom);

		String room[] = new String[] { "console Room", "VR Room", "PC Room" };

		// list to show types of rooms
		roomtype = new JComboBox(room);
		roomtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (roomtype.getSelectedIndex() == 0) {
					r = "console Room";
				}
				if (roomtype.getSelectedIndex() == 1) {
					r = "VR Room";
				}
				if (roomtype.getSelectedIndex() == 2) {
					r = "PC Room";
				}
			}
		});
		roomtype.setBounds(245, 94, 150, 27);
		roomtype.setVisible(false);
		win2.getContentPane().add(roomtype);

		// initializing label
		typeofroom = new JLabel("Type of Room:");
		typeofroom.setBounds(146, 98, 95, 16);
		typeofroom.setVisible(false);
		win2.getContentPane().add(typeofroom);

		LNOB = new JLabel("Select Building:");
		LNOB.setBounds(140, 59, 100, 16);
		LNOB.setVisible(false);
		win2.getContentPane().add(LNOB);

		numofroom = new JLabel("Number of rooms:");
		numofroom.setBounds(5, 16, 120, 15);
		numofroom.setVisible(false);
		win2.getContentPane().add(numofroom);

		LNOR = new JLabel();
		LNOR.setVisible(false);
		if (owner.getBuldings().isEmpty()) {
			LNOR.setText("0");
		} else {
			LNOR.setText(Integer.toString(owner.getBuldings().get(numofbulding.getSelectedIndex()).getRooms().size()));
		}
		LNOR.setBounds(125, 17, 30, 15);
		win2.getContentPane().add(LNOR);

		wnametxt = new JTextField();
		wnametxt.setBounds(325, 38, 150, 30);
		wnametxt.setVisible(false);
		win2.getContentPane().add(wnametxt);

		lWname = new JLabel("name:");
		lWname.setBounds(280, 45, 38, 16);
		lWname.setVisible(false);
		win2.getContentPane().add(lWname);

		wagetxt = new JTextField();
		wagetxt.setBounds(325, 73, 150, 30);
		wagetxt.setVisible(false);
		win2.getContentPane().add(wagetxt);

		lwage = new JLabel("Age:");
		lwage.setBounds(290, 80, 28, 16);
		lwage.setVisible(false);
		win2.getContentPane().add(lwage);

		wphtxt = new JTextField();
		wphtxt.setBounds(325, 108, 150, 30);
		wphtxt.setVisible(false);
		win2.getContentPane().add(wphtxt);

		lwph = new JLabel("Phone number:");
		lwph.setBounds(223, 115, 95, 16);
		lwph.setVisible(false);
		win2.getContentPane().add(lwph);

		whourstxt = new JTextField();
		whourstxt.setBounds(325, 143, 150, 30);
		whourstxt.setVisible(false);
		win2.getContentPane().add(whourstxt);

		lwhours = new JLabel("Work Hours:");
		lwhours.setBounds(240, 150, 78, 16);
		lwhours.setVisible(false);
		win2.getContentPane().add(lwhours);

		wsalarytxt = new JTextField();
		wsalarytxt.setColumns(10);
		wsalarytxt.setBounds(325, 178, 150, 30);
		wsalarytxt.setVisible(false);
		win2.getContentPane().add(wsalarytxt);

		lwsalary = new JLabel("Salary:");
		lwsalary.setBounds(277, 185, 41, 16);
		lwsalary.setVisible(false);
		win2.getContentPane().add(lwsalary);

		
		wbuild = new JComboBox();
		wbuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TCnum.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getnumoftc()));
				MAnum.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getnumofma()));
				Cnum.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getnumofca()));
				active.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getNumofactive()));
				inactive.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getNumofinactive()));
			}
		});
		wbuild.setBounds(325, 213, 150, 27);
		wbuild.setVisible(false);
		win2.getContentPane().add(wbuild);
		

		lwbuild = new JLabel("Select Building:");
		lwbuild.setBounds(218, 217, 100, 16);
		lwbuild.setVisible(false);
		win2.getContentPane().add(lwbuild);

		jobs = new String[] { "Cleaner", "Technation", "Manegar" };

		job = new JComboBox(jobs);
		job.setBounds(325, 245, 150, 27);
		job.setVisible(false);
		win2.getContentPane().add(job);

		ljob = new JLabel("Job:");
		ljob.setBounds(290, 249, 28, 16);
		ljob.setVisible(false);
		win2.getContentPane().add(ljob);

		genders = new String[] { "Male", "Female" };

		gender = new JComboBox(genders);
		gender.setBounds(325, 277, 150, 27);
		gender.setVisible(false);
		win2.getContentPane().add(gender);

		lgender = new JLabel("Gender:");
		lgender.setBounds(268, 281, 50, 16);
		lgender.setVisible(false);
		win2.getContentPane().add(lgender);

		NUMofTC = new JLabel("Technations:");
		NUMofTC.setBounds(5, 10, 81, 16);
		NUMofTC.setVisible(false);
		win2.getContentPane().add(NUMofTC);

		NUMofMA = new JLabel("Manegars:");
		NUMofMA.setVisible(false);
		NUMofMA.setBounds(5, 45, 65, 16);
		win2.getContentPane().add(NUMofMA);

		NUMofC = new JLabel("Cleaners:");
		NUMofC.setVisible(false);
		NUMofC.setBounds(5, 80, 61, 16);
		win2.getContentPane().add(NUMofC);

		numOFactive = new JLabel("Active Workers:");
		numOFactive.setBounds(5, 115, 99, 16);
		numOFactive.setVisible(false);
		win2.getContentPane().add(numOFactive);

		numOFinactive = new JLabel("InActive Workers:");
		numOFinactive.setVisible(false);
		numOFinactive.setBounds(5, 150, 110, 16);
		win2.getContentPane().add(numOFinactive);

		TCnum = new JLabel();
		TCnum.setVisible(false);
		TCnum.setBounds(98, 10, 61, 16);
		win2.getContentPane().add(TCnum);

		MAnum = new JLabel();
		MAnum.setVisible(false);
		MAnum.setBounds(82, 45, 61, 16);
		win2.getContentPane().add(MAnum);

		Cnum = new JLabel();
		Cnum.setVisible(false);
		Cnum.setBounds(78, 80, 61, 16);
		win2.getContentPane().add(Cnum);

		active = new JLabel();
		active.setVisible(false);
		active.setBounds(111, 115, 61, 16);
		win2.getContentPane().add(active);

		inactive = new JLabel();
		inactive.setVisible(false);
		inactive.setBounds(122, 150, 61, 16);
		win2.getContentPane().add(inactive);

		addw = new JButton("ADD Worker");
		addw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					owner.getBuldings().get(wbuild.getSelectedIndex())
							.addWorker(new Workrs(wnametxt.getText(), Integer.valueOf(wagetxt.getText()),
									(String) gender.getSelectedItem(), wphtxt.getText(), (String) job.getSelectedItem(),
									Integer.valueOf(whourstxt.getText()), Double.valueOf(wsalarytxt.getText())));
					SHW.addItem(owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers().get(c2).getName()+":"+owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers().get(c2).getWorkrID());
					TCnum.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getnumoftc()));
					MAnum.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getnumofma()));
					Cnum.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getnumofca()));
					active.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getNumofactive()));
					inactive.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getNumofinactive()));

					c2++;

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "there is no building to add workers");

				}

			}
		});
		addw.setBounds(240, 315, 230, 29);
		addw.setVisible(false);
		win2.getContentPane().add(addw);
		/*
		 * SHB.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * 
		 * //SHW.removeAll(); for(int i=0;
		 * i<owner.getBuldings().get(SHB.getSelectedIndex()).getWorkers().size(); i++) {
		 * SHW.removeItem(owner.getBuldings().get(SHB.getSelectedIndex()).getWorkers().
		 * get(i)); } for(int i=0;
		 * i<owner.getBuldings().get(SHB.getSelectedIndex()).getWorkers().size(); i++) {
		 * SHW.addItem(owner.getBuldings().get(SHB.getSelectedIndex()).getWorkers().get(
		 * i).getName()); } win4.add(SHW); }
		 * 
		 * });
		 */
		wshow = new JButton("Worker Details");
		wshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					win4.setVisible(true);

					SHW.setVisible(true);

					//SHB.setVisible(true);
/*
					JLabel LWSB = new JLabel("Select Bilding:");
					LWSB.setBounds(30, 5, 90, 15);
					win4.add(LWSB);
					*/

					JLabel LWSW = new JLabel("Select Worker");
					LWSW.setHorizontalAlignment(SwingConstants.CENTER);
					LWSW.setBounds(112, 4, 95, 15);
					win4.getContentPane().add(LWSW);

					JLabel lwn = new JLabel("Name:");
					lwn.setBounds(5, 65, 40, 16);
					win4.getContentPane().add(lwn);

					JLabel lwa = new JLabel("Age:");
					lwa.setBounds(5, 91, 28, 16);
					win4.getContentPane().add(lwa);

					JLabel lwp = new JLabel("Phone Number:");
					lwp.setBounds(5, 117, 98, 16);
					win4.getContentPane().add(lwp);

					JLabel lwg = new JLabel("Gender:");
					lwg.setBounds(5, 143, 48, 16);
					win4.getContentPane().add(lwg);

					JLabel lwj = new JLabel("Job:");
					lwj.setBounds(5, 169, 24, 16);
					win4.getContentPane().add(lwj);

					JLabel lwID = new JLabel("Worker ID:");
					lwID.setBounds(5, 195, 66, 16);
					win4.getContentPane().add(lwID);

					JLabel lwwh = new JLabel("Work Hours:");
					lwwh.setBounds(5, 221, 78, 16);
					win4.getContentPane().add(lwwh);

					JLabel lws = new JLabel("Salary Per Year:");
					lws.setBounds(5, 247, 98, 16);
					win4.getContentPane().add(lws);

					JLabel lwst = new JLabel("Worker Status:");
					lwst.setBounds(5, 273, 93, 16);
					win4.getContentPane().add(lwst);

					JLabel LWN = new JLabel();
					LWN.setBounds(50, 65, 70, 16);
					win4.getContentPane().add(LWN);

					JLabel LWA = new JLabel();
					LWA.setBounds(38, 93, 24, 16);
					win4.getContentPane().add(LWA);

					JLabel LWPH = new JLabel();
					LWPH.setBounds(108, 117, 115, 16);
					win4.getContentPane().add(LWPH);

					JLabel LWG = new JLabel();
					LWG.setBounds(58, 145, 48, 16);
					win4.getContentPane().add(LWG);

					JLabel LWJ = new JLabel();
					LWJ.setBounds(34, 169, 72, 16);
					win4.getContentPane().add(LWJ);

					JLabel LWWH = new JLabel();
					LWWH.setBounds(88, 221, 16, 16);
					win4.getContentPane().add(LWWH);

					JLabel LWID = new JLabel();
					LWID.setBounds(76, 195, 66, 16);
					win4.getContentPane().add(LWID);

					JLabel LWS = new JLabel();
					LWS.setBounds(108, 247, 61, 16);
					win4.getContentPane().add(LWS);

					JLabel LWST = new JLabel();
					LWST.setBounds(103, 273, 61, 16);
					win4.getContentPane().add(LWST);
					win4.setLocationRelativeTo(null);

					JButton SH = new JButton("Show");
					SH.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							LWN.setText(owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers()
									.get(SHW.getSelectedIndex()).getName());

							LWA.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers()
									.get(SHW.getSelectedIndex()).getAge()));

							LWPH.setText(owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers()
									.get(SHW.getSelectedIndex()).getPhonenumber());

							LWG.setText(owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers()
									.get(SHW.getSelectedIndex()).getGender());

							LWJ.setText(owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers()
									.get(SHW.getSelectedIndex()).getJob());

							LWWH.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers()
									.get(SHW.getSelectedIndex()).getWorkhours()));

							LWID.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers()
									.get(SHW.getSelectedIndex()).getWorkrID()));

							LWS.setText(String.valueOf(owner.getBuldings().get(wbuild.getSelectedIndex()).getWorkers()
									.get(SHW.getSelectedIndex()).getSalary() * 12));

							LWST.setText("???");

						}
					});
					SH.setBounds(5, 299, 150, 29);
					win4.getContentPane().add(SH);

					JButton editw = new JButton("Edit");
					editw.setBounds(160, 299, 150, 29);
					win4.getContentPane().add(editw);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "there is no workers");
				}

			}
		});
		wshow.setBounds(5, 315, 230, 29);
		wshow.setVisible(false);
		win2.getContentPane().add(wshow);

		pnametxt = new JTextField();
		pnametxt.setVisible(false);
		pnametxt.setBounds(324, 133, 150, 30);
		win2.getContentPane().add(pnametxt);

		scbp = new JComboBox();
		scbp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lnumPc.setText(String.valueOf(owner.getBuldings().get(scbp.getSelectedIndex()).getnumPc()));
				lnumofPv.setText(String.valueOf(owner.getBuldings().get(scbp.getSelectedIndex()).getnumofPv()));
				lnumofPp.setText(String.valueOf(owner.getBuldings().get(scbp.getSelectedIndex()).getnumofPp()));
				lnumofP.setText(String.valueOf(owner.getBuldings().get(scbp.getSelectedIndex()).getPlayers().size()));
			}
		});
		scbp.setVisible(false);
		scbp.setBounds(324, 55, 150, 27);
		win2.getContentPane().add(scbp);

		rooms = new String[] { "console Room", "VR Room", "PC Room" };

		scrp = new JComboBox(rooms);
		scrp.setVisible(false);
		scrp.setBounds(324, 94, 150, 27);
		win2.getContentPane().add(scrp);

		addp = new JButton("ADD Player");
		addp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				owner.getBuldings().get(scbp.getSelectedIndex())
				.addPlayer(new Players(pnametxt.getName(), Integer.valueOf(pagetxt.getText()), pphtxt.getText(), scrp.getSelectedItem().toString()));
				lnumPc.setText(String.valueOf(owner.getBuldings().get(scbp.getSelectedIndex()).getnumPc()));
				lnumofPv.setText(String.valueOf(owner.getBuldings().get(scbp.getSelectedIndex()).getnumofPv()));
				lnumofPp.setText(String.valueOf(owner.getBuldings().get(scbp.getSelectedIndex()).getnumofPp()));
				lnumofP.setText(String.valueOf(owner.getBuldings().get(scbp.getSelectedIndex()).getPlayers().size()));
				}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "there is no building to add Players");
			}
				
				
			}
		});
		addp.setVisible(false);
		addp.setBounds(245, 259, 230, 29);
		win2.getContentPane().add(addp);

		Finishbt = new JButton("Finish");
		Finishbt.setVisible(false);
		Finishbt.setBounds(5, 259, 230, 29);
		win2.getContentPane().add(Finishbt);

		pagetxt = new JTextField();
		pagetxt.setVisible(false);
		pagetxt.setBounds(324, 175, 150, 30);
		win2.getContentPane().add(pagetxt);

		pphtxt = new JTextField();
		pphtxt.setVisible(false);
		pphtxt.setBounds(324, 217, 150, 30);
		win2.getContentPane().add(pphtxt);

		lscrp = new JLabel("Select Room:");
		lscrp.setVisible(false);
		lscrp.setBounds(235, 98, 81, 16);
		win2.getContentPane().add(lscrp);

		lscbp = new JLabel("Select Building:");
		lscbp.setVisible(false);
		lscbp.setBounds(220, 59, 98, 16);
		win2.getContentPane().add(lscbp);

		lpname = new JLabel("Name:");
		lpname.setVisible(false);
		lpname.setBounds(279, 140, 40, 16);
		win2.getContentPane().add(lpname);

		lpage = new JLabel("Age:");
		lpage.setVisible(false);
		lpage.setBounds(291, 182, 28, 16);
		win2.getContentPane().add(lpage);

		lpph = new JLabel("Phone Number:");
		lpph.setVisible(false);
		lpph.setBounds(224, 224, 98, 16);
		win2.getContentPane().add(lpph);

		numofPinc = new JLabel("Players in Console Room:");
		numofPinc.setVisible(false);
		numofPinc.setBounds(5, 20, 160, 16);
		win2.getContentPane().add(numofPinc);

		numofPinv = new JLabel("Players in VR Room:");
		numofPinv.setVisible(false);
		numofPinv.setBounds(5, 59, 125, 16);
		win2.getContentPane().add(numofPinv);

		numofPinp = new JLabel("Players in PC Room:");
		numofPinp.setVisible(false);
		numofPinp.setBounds(5, 98, 125, 16);
		win2.getContentPane().add(numofPinp);

		numofP = new JLabel("All Player:");
		numofP.setVisible(false);
		numofP.setBounds(5, 140, 62, 16);
		win2.getContentPane().add(numofP);

		lnumPc = new JLabel("");
		lnumPc.setVisible(false);
		lnumPc.setBounds(170, 20, 61, 16);
		win2.getContentPane().add(lnumPc);

		lnumofPv = new JLabel("");
		lnumofPv.setVisible(false);
		lnumofPv.setBounds(135, 59, 61, 16);
		win2.getContentPane().add(lnumofPv);

		lnumofPp = new JLabel("");
		lnumofPp.setVisible(false);
		lnumofPp.setBounds(135, 98, 61, 16);
		win2.getContentPane().add(lnumofPp);

		lnumofP = new JLabel("");
		lnumofP.setVisible(false);
		lnumofP.setBounds(72, 140, 61, 16);
		win2.getContentPane().add(lnumofP);

		String list[] = { "Owner", "Buildings", "Workers", "Players" };

		// list to switch between frames
		JComboBox listbox = new JComboBox(list);
		listbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listbox.getSelectedIndex() == 0) {

					win2.setSize(400, 300);
					Ownername.setVisible(true);
					Photo.setVisible(true);
					panel.setVisible(true);
					name.setVisible(true);
					phonenum.setVisible(true);
					Name.setVisible(true);
					Phonenum.setVisible(true);
					age.setVisible(true);
					Age.setVisible(true);
					buid.setVisible(true);
					numofbuild.setVisible(true);
					NOB.setVisible(true);
					nameofB.setVisible(true);
					Addb.setVisible(true);
					edit.setVisible(true);

					listbox.setBounds(245, 16, 150, 27);
					sector.setBounds(185, 20, 55, 16);
					Name.setText(owner.getName());
					Phonenum.setText(owner.getPhoneNumber());
					Age.setText(String.valueOf(owner.getAge()));
					numofbuild.setText(String.valueOf(owner.numofbuldings()));

					priceofroom.setVisible(false);
					price.setVisible(false);
					Addroom.setVisible(false);
					roomtype.setVisible(false);
					typeofroom.setVisible(false);
					numofbulding.setVisible(false);
					LNOB.setVisible(false);
					LNOR.setVisible(false);
					numofroom.setVisible(false);
					Show.setVisible(false);
					wnametxt.setVisible(false);
					lWname.setVisible(false);
					wagetxt.setVisible(false);
					lwage.setVisible(false);
					wphtxt.setVisible(false);
					lwph.setVisible(false);
					whourstxt.setVisible(false);
					lwhours.setVisible(false);
					wsalarytxt.setVisible(false);
					lwsalary.setVisible(false);
					wbuild.setVisible(false);
					lwbuild.setVisible(false);
					job.setVisible(false);
					ljob.setVisible(false);
					gender.setVisible(false);
					lgender.setVisible(false);
					lgender.setVisible(false);
					addw.setVisible(false);
					wshow.setVisible(false);
					NUMofTC.setVisible(false);
					NUMofMA.setVisible(false);
					NUMofC.setVisible(false);
					numOFactive.setVisible(false);
					numOFinactive.setVisible(false);
					TCnum.setVisible(false);
					MAnum.setVisible(false);
					Cnum.setVisible(false);
					active.setVisible(false);
					inactive.setVisible(false);
					pnametxt.setVisible(false);
					scbp.setVisible(false);
					addp.setVisible(false);
					Finishbt.setVisible(false);
					scrp.setVisible(false);
					pagetxt.setVisible(false);
					pphtxt.setVisible(false);
					lscrp.setVisible(false);
					lscbp.setVisible(false);
					lpname.setVisible(false);
					lpage.setVisible(false);
					lpph.setVisible(false);
					numofPinc.setVisible(false);
					numofPinv.setVisible(false);
					numofPinp.setVisible(false);
					numofP.setVisible(false);
					lnumPc.setVisible(false);
					lnumofPv.setVisible(false);
					lnumofPp.setVisible(false);
					lnumofP.setVisible(false);

				} else if (listbox.getSelectedIndex() == 1) {

					win2.setSize(400, 300);
					Ownername.setVisible(false);
					Photo.setVisible(false);
					panel.setVisible(false);
					name.setVisible(false);
					phonenum.setVisible(false);
					Name.setVisible(false);
					Phonenum.setVisible(false);
					age.setVisible(false);
					Age.setVisible(false);
					buid.setVisible(false);
					numofbuild.setVisible(false);
					NOB.setVisible(false);
					nameofB.setVisible(false);
					Addb.setVisible(false);
					edit.setVisible(false);
					wnametxt.setVisible(false);
					lWname.setVisible(false);
					wagetxt.setVisible(false);
					lwage.setVisible(false);
					wphtxt.setVisible(false);
					lwph.setVisible(false);
					whourstxt.setVisible(false);
					lwhours.setVisible(false);
					wsalarytxt.setVisible(false);
					lwsalary.setVisible(false);
					wbuild.setVisible(false);
					lwbuild.setVisible(false);
					job.setVisible(false);
					ljob.setVisible(false);
					gender.setVisible(false);
					lgender.setVisible(false);
					lgender.setVisible(false);
					addw.setVisible(false);
					wshow.setVisible(false);
					NUMofTC.setVisible(false);
					NUMofMA.setVisible(false);
					NUMofC.setVisible(false);
					numOFactive.setVisible(false);
					numOFinactive.setVisible(false);
					TCnum.setVisible(false);
					MAnum.setVisible(false);
					Cnum.setVisible(false);
					active.setVisible(false);
					inactive.setVisible(false);
					pnametxt.setVisible(false);
					scbp.setVisible(false);
					addp.setVisible(false);
					Finishbt.setVisible(false);
					scrp.setVisible(false);
					pagetxt.setVisible(false);
					pphtxt.setVisible(false);
					lscrp.setVisible(false);
					lscbp.setVisible(false);
					lpname.setVisible(false);
					lpage.setVisible(false);
					lpph.setVisible(false);
					numofPinc.setVisible(false);
					numofPinv.setVisible(false);
					numofPinp.setVisible(false);
					numofP.setVisible(false);
					lnumPc.setVisible(false);
					lnumofPv.setVisible(false);
					lnumofPp.setVisible(false);
					lnumofP.setVisible(false);

					listbox.setBounds(245, 16, 150, 27);
					sector.setBounds(185, 20, 55, 16);

					priceofroom.setVisible(true);
					price.setVisible(true);
					Addroom.setVisible(true);
					roomtype.setVisible(true);
					typeofroom.setVisible(true);
					numofbulding.setVisible(true);
					LNOB.setVisible(true);
					numofroom.setVisible(true);
					LNOR.setVisible(true);
					Show.setVisible(true);

				}

				else if (listbox.getSelectedIndex() == 2) {

					win2.setSize(480, 380);
					LNOR.setVisible(false);
					Ownername.setVisible(false);
					Photo.setVisible(false);
					panel.setVisible(false);
					name.setVisible(false);
					phonenum.setVisible(false);
					Name.setVisible(false);
					Phonenum.setVisible(false);
					age.setVisible(false);
					Age.setVisible(false);
					buid.setVisible(false);
					numofbuild.setVisible(false);
					NOB.setVisible(false);
					nameofB.setVisible(false);
					Addb.setVisible(false);
					priceofroom.setVisible(false);
					price.setVisible(false);
					Addroom.setVisible(false);
					roomtype.setVisible(false);
					typeofroom.setVisible(false);
					numofbulding.setVisible(false);
					LNOB.setVisible(false);
					numofroom.setVisible(false);
					Show.setVisible(false);
					edit.setVisible(false);
					pnametxt.setVisible(false);
					scbp.setVisible(false);
					addp.setVisible(false);
					Finishbt.setVisible(false);
					scrp.setVisible(false);
					pagetxt.setVisible(false);
					pphtxt.setVisible(false);
					lscrp.setVisible(false);
					lscbp.setVisible(false);
					lpname.setVisible(false);
					lpage.setVisible(false);
					lpph.setVisible(false);
					numofPinc.setVisible(false);
					numofPinv.setVisible(false);
					numofPinp.setVisible(false);
					numofP.setVisible(false);
					lnumPc.setVisible(false);
					lnumofPv.setVisible(false);
					lnumofPp.setVisible(false);
					lnumofP.setVisible(false);

					listbox.setBounds(325, 6, 150, 27);
					sector.setBounds(263, 10, 55, 16);

					wnametxt.setVisible(true);
					lWname.setVisible(true);
					wagetxt.setVisible(true);
					lwage.setVisible(true);
					wphtxt.setVisible(true);
					lwph.setVisible(true);
					whourstxt.setVisible(true);
					lwhours.setVisible(true);
					wsalarytxt.setVisible(true);
					lwsalary.setVisible(true);
					wbuild.setVisible(true);
					lwbuild.setVisible(true);
					job.setVisible(true);
					ljob.setVisible(true);
					gender.setVisible(true);
					lgender.setVisible(true);
					lgender.setVisible(true);
					addw.setVisible(true);
					wshow.setVisible(true);
					NUMofTC.setVisible(true);
					NUMofMA.setVisible(true);
					NUMofC.setVisible(true);
					numOFactive.setVisible(true);
					numOFinactive.setVisible(true);
					TCnum.setVisible(true);
					MAnum.setVisible(true);
					Cnum.setVisible(true);
					active.setVisible(true);
					inactive.setVisible(true);

				} else if (listbox.getSelectedIndex() == 3) {

					win2.setSize(480, 320);

					Ownername.setVisible(false);
					Photo.setVisible(false);
					panel.setVisible(false);
					name.setVisible(false);
					phonenum.setVisible(false);
					Name.setVisible(false);
					Phonenum.setVisible(false);
					age.setVisible(false);
					Age.setVisible(false);
					buid.setVisible(false);
					numofbuild.setVisible(false);
					NOB.setVisible(false);
					nameofB.setVisible(false);
					Addb.setVisible(false);
					priceofroom.setVisible(false);
					price.setVisible(false);
					Addroom.setVisible(false);
					roomtype.setVisible(false);
					typeofroom.setVisible(false);
					numofbulding.setVisible(false);
					LNOB.setVisible(false);
					numofroom.setVisible(false);
					LNOR.setVisible(false);
					Show.setVisible(false);
					edit.setVisible(false);
					wnametxt.setVisible(false);
					lWname.setVisible(false);
					wagetxt.setVisible(false);
					lwage.setVisible(false);
					wphtxt.setVisible(false);
					lwph.setVisible(false);
					whourstxt.setVisible(false);
					lwhours.setVisible(false);
					wsalarytxt.setVisible(false);
					lwsalary.setVisible(false);
					wbuild.setVisible(false);
					lwbuild.setVisible(false);
					job.setVisible(false);
					ljob.setVisible(false);
					gender.setVisible(false);
					lgender.setVisible(false);
					lgender.setVisible(false);
					addw.setVisible(false);
					wshow.setVisible(false);
					NUMofTC.setVisible(false);
					NUMofMA.setVisible(false);
					NUMofC.setVisible(false);
					numOFactive.setVisible(false);
					numOFinactive.setVisible(false);
					TCnum.setVisible(false);
					MAnum.setVisible(false);
					Cnum.setVisible(false);
					active.setVisible(false);
					inactive.setVisible(false);

					listbox.setBounds(324, 16, 150, 27);
					sector.setBounds(264, 20, 55, 16);

					pnametxt.setVisible(true);
					scbp.setVisible(true);
					addp.setVisible(true);
					Finishbt.setVisible(true);
					scrp.setVisible(true);
					pagetxt.setVisible(true);
					pphtxt.setVisible(true);
					lscrp.setVisible(true);
					lscbp.setVisible(true);
					lpname.setVisible(true);
					lpage.setVisible(true);
					lpph.setVisible(true);
					numofPinc.setVisible(true);
					numofPinv.setVisible(true);
					numofPinp.setVisible(true);
					numofP.setVisible(true);
					lnumPc.setVisible(true);
					lnumofPv.setVisible(true);
					lnumofPp.setVisible(true);
					lnumofP.setVisible(true);

				}
			}
		});
		listbox.setBounds(245, 16, 150, 27);
		win2.getContentPane().add(listbox);

		Ownername = new JLabel(owner.getUsername());
		Ownername.setHorizontalAlignment(SwingConstants.CENTER);
		Ownername.setBounds(15, 70, 60, 15);
		win2.getContentPane().add(Ownername);

		ImageIcon image = new ImageIcon("//Users/ahmad/Downloads/user.png");
		Image img = (image).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		image = new ImageIcon(img);

		Photo = new JLabel();
		Photo.setHorizontalAlignment(SwingConstants.CENTER);
		Photo.setIcon(image);
		Photo.setBounds(15, 5, 60, 60);
		win2.getContentPane().add(Photo);

		panel = new JPanel();
		panel.setBackground(new Color(191, 191, 191));
		panel.setBounds(5, 5, 80, 85);
		win2.getContentPane().add(panel);

		// button to change owner attribute
		edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win3 = new JFrame("Edit");
				win3.setSize(300, 200);
				win3.setLocationRelativeTo(null);
				win3.getContentPane().setLayout(null);
				win3.setVisible(true);

				JLabel namee = new JLabel("Name:");
				namee.setBounds(55, 13, 45, 15);
				win3.getContentPane().add(namee);

				JLabel phonenume = new JLabel("Phone number:");
				phonenume.setBounds(5, 55, 95, 15);
				win3.getContentPane().add(phonenume);

				JLabel agee = new JLabel("Age:");
				agee.setBounds(70, 97, 30, 15);
				win3.getContentPane().add(agee);

				JTextField nametxt = new JTextField();
				nametxt.setBounds(110, 5, 130, 30);
				win3.getContentPane().add(nametxt);
				nametxt.setColumns(10);

				JTextField phtxt = new JTextField();
				phtxt.setBounds(110, 47, 130, 30);
				win3.getContentPane().add(phtxt);
				phtxt.setColumns(10);

				JTextField agetxt = new JTextField();
				agetxt.setBounds(110, 89, 130, 30);
				win3.getContentPane().add(agetxt);
				agetxt.setColumns(10);

				JButton sv = new JButton("Save");
				sv.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (phtxt.getText().isBlank() && agetxt.getText().isBlank() && !nametxt.getText().isBlank()) {
							Name.setText(nametxt.getText());
							owner.setName(nametxt.getText());
							Age.setText(Integer.toString(owner.getAge()));
							Phonenum.setText(owner.getPhoneNumber());
							System.out.println("hi2");

							win3.dispose();
						} else if (phtxt.getText().isBlank() && !agetxt.getText().isBlank()
								&& nametxt.getText().isBlank()) {
							Age.setText(agetxt.getText());
							owner.setAge(Integer.valueOf(agetxt.getText()));
							Name.setText(owner.getName());
							Phonenum.setText(owner.getPhoneNumber());
							System.out.println("hi3");

							win3.dispose();
						} else if (!phtxt.getText().isBlank() && agetxt.getText().isBlank()
								&& nametxt.getText().isBlank()) {
							Phonenum.setText(phtxt.getText());
							owner.setPhoneNumber(phtxt.getText());
							Age.setText(Integer.toString(owner.getAge()));
							Name.setText(owner.getName());
							System.out.println("hi4");

							win3.dispose();
						} else if (phtxt.getText().isBlank() && agetxt.getText().isBlank()
								&& nametxt.getText().isBlank()) {
							Phonenum.setText(owner.getPhoneNumber());
							Age.setText(Integer.toString(owner.getAge()));
							Name.setText(owner.getName());
							System.out.println("hi5");

							win3.dispose();
						} else if (!phtxt.getText().isBlank() && !agetxt.getText().isBlank()
								&& nametxt.getText().isBlank()) {
							Phonenum.setText(phtxt.getText());
							owner.setPhoneNumber(phtxt.getText());
							Age.setText((agetxt.getText()));
							owner.setAge(Integer.valueOf(agetxt.getText()));
							Name.setText(owner.getName());
							System.out.println("hi6");

							win3.dispose();
						} else if (!phtxt.getText().isBlank() && agetxt.getText().isBlank()
								&& !nametxt.getText().isBlank()) {
							Phonenum.setText(phtxt.getText());
							owner.setPhoneNumber(phtxt.getText());
							Age.setText(String.valueOf(owner.getAge()));
							Name.setText(nametxt.getText());
							owner.setName(nametxt.getText());
							System.out.println("hi7");

							win3.dispose();
						} else if (phtxt.getText().isBlank() && !agetxt.getText().isBlank()
								&& !nametxt.getText().isBlank()) {
							Phonenum.setText(owner.getPhoneNumber());
							Age.setText(agetxt.getText());
							owner.setAge(Integer.valueOf(agetxt.getText()));
							Name.setText(nametxt.getText());
							owner.setName(nametxt.getText());
							System.out.println("hi8");

							win3.dispose();
						}

						else {
							win3.dispose();
							Name.setText(nametxt.getText());
							owner.setName(nametxt.getText());
							Age.setText(agetxt.getText());
							owner.setAge(Integer.valueOf(agetxt.getText()));
							Phonenum.setText(phtxt.getText());
							owner.setPhoneNumber(phtxt.getText());
							System.out.println("hi");
						}
					}
				});
				sv.setBounds(5, 131, 120, 30);
				win3.getContentPane().add(sv);

				JButton cancel = new JButton("Cancel");
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						win3.dispose();
					}
				});
				cancel.setBounds(177, 132, 117, 29);
				win3.getContentPane().add(cancel);
			}
		});

		edit.setBounds(335, 237, 60, 29);
		win2.getContentPane().add(edit);

		// label
		name = new JLabel("Name:");
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setBounds(6, 110, 40, 15);
		win2.getContentPane().add(name);

		// label
		phonenum = new JLabel("Phone number:");
		phonenum.setBounds(6, 135, 95, 15);
		win2.getContentPane().add(phonenum);

		// label
		sector = new JLabel("Sectors:");
		sector.setBounds(185, 20, 55, 16);
		win2.getContentPane().add(sector);

		// label
		Name = new JLabel(owner.getName());
		Name.setBounds(56, 110, 75, 15);
		win2.getContentPane().add(Name);

		// label
		Phonenum = new JLabel(owner.getPhoneNumber());
		Phonenum.setBounds(111, 135, 110, 15);
		win2.getContentPane().add(Phonenum);

		// label
		age = new JLabel("Age:");
		age.setHorizontalAlignment(SwingConstants.LEFT);
		age.setBounds(6, 160, 30, 15);
		win2.getContentPane().add(age);

		// label
		Age = new JLabel(String.valueOf(owner.getAge()));
		Age.setBounds(41, 159, 20, 15);
		win2.getContentPane().add(Age);

		// label
		buid = new JLabel("Building Owned:");
		buid.setBounds(6, 185, 105, 15);
		win2.getContentPane().add(buid);

		// label
		numofbuild = new JLabel(String.valueOf(owner.numofbuldings()));
		numofbuild.setBounds(121, 184, 20, 15);
		win2.getContentPane().add(numofbuild);

	}

	// method to login

	public static void Login() {

		// login frame
		win = new JFrame("Login");
		win.setSize(350, 310);
		win.setLocationRelativeTo(null);
		win.setVisible(true);
		win.getContentPane().setLayout(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// win.setResizable(false);

		// label
		JLabel l1 = new JLabel("Sgin in");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Arial", Font.BOLD, 14));
		l1.setBounds(145, 55, 60, 30);
		win.getContentPane().add(l1);

		// label
		JLabel l2 = new JLabel("Username");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setBounds(35, 95, 80, 20);
		win.getContentPane().add(l2);

		// label
		JLabel l3 = new JLabel("Password");
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setBounds(35, 165, 80, 20);
		win.getContentPane().add(l3);

		// ImageIcon to add image to the login frame
		ImageIcon image = new ImageIcon("/Users/ahmad/Downloads/user.png");
		Image img = (image).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		image = new ImageIcon(img);

		// label
		JLabel Photo = new JLabel();
		Photo.setHorizontalAlignment(SwingConstants.CENTER);
		Photo.setIcon(image);
		Photo.setBounds(150, 5, 50, 50);
		win.getContentPane().add(Photo);

		// check box to show the password
		JCheckBox box1 = new JCheckBox("Show password");
		box1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (box1.isSelected()) {
					p1.setEchoChar((char) 0);
				} else
					p1.setEchoChar('\u25CF');
			}
		});
		box1.setBounds(35, 205, 130, 23);
		win.getContentPane().add(box1);

		t1 = new JTextField();
		t1.setBounds(130, 90, 170, 35);
		win.getContentPane().add(t1);
		t1.setColumns(10);

		p1 = new JPasswordField();
		p1.setBounds(130, 155, 170, 35);
		win.getContentPane().add(p1);

		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = t1.getText();
				String pwd = new String(p1.getPassword());
				if (user.equalsIgnoreCase(owner.getUsername()) && pwd.equalsIgnoreCase(owner.getPassword())) {
					win.dispose();
					System();
					win2.setVisible(true);
					// calling the system method

				}
				else if (c3==2) {
					System.exit(0);
				}
				else {
					l4.setVisible(true);
					c3++;
				}
			}
		});
		login.setBounds(165, 205, 80, 29);
		win.getContentPane().add(login);

		l4 = new JLabel("The password or the username is wrong");
		l4.setForeground(new Color(255, 38, 0));
		l4.setBounds(35, 248, 260, 30);
		l4.setVisible(false);
		win.getContentPane().add(l4);

	}

	public static void main(String[] args) {

		// calling the login method
		Login();

		/*
		 * fixed declaration and initializing for object
		 * 
		 * Room consoleRoom = new Room("console Room", 1.5); Room vrRoom = new
		 * Room("vrRoom", 2.5); Room pcRoom = new Room("pcRoom", 2);
		 * 
		 * Workrs worker1 = new Workrs("lizzy", 24, "female", "+962774656787",
		 * "cleaner", 8, 550, true); Workrs worker2 = new Workrs("saed", 26, "male",
		 * "+962784654797", "technation", 8, 550, true);
		 * 
		 * Players player1 = new Players("Noor", 28, "+962777456321", 6, 1.5); Players
		 * player2 = new Players("omar", 28, "+962777456321", 6, 1.5);
		 * 
		 * 
		 * building.addRoom(consoleRoom); building.addRoom(vrRoom);
		 * building.addRoom(pcRoom);
		 * 
		 * building.addWorker(worker1); building.addWorker(worker2);
		 * 
		 * building.addPlayer(player1); building.addPlayer(player2);
		 * 
		 * building.setOwner(owner); owner.addBulding(building); // owner.printOinfo();
		 */

	}
}