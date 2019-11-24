package ie.ul.hbs2.GUI;

import ie.ul.hbs2.common.BackCommand;
import ie.ul.hbs2.common.DoNothingCommand;
import ie.ul.hbs2.database.DatabaseHelper;
import ie.ul.hbs2.database.Query;
import ie.ul.hbs2.logging.ContextObject;
import ie.ul.hbs2.logging.interceptors.LoggingInterceptor;
import ie.ul.hbs2.management.*;
import ie.ul.hbs2.memento.CareTaker;

import java.sql.Timestamp;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class ManagementView extends View {

    private final TotalWagesVisitor totalWagesVisitor = new TotalWagesVisitorImpl();
    private final EmployeeListVisitor employeeListVisitor = new EmployeeListVisitorImpl();
    private final DatabaseHelper db = DatabaseHelper.getInstance();
    private LoggingInterceptor interceptor = new LoggingInterceptor();
    private ContextObject context;

    public ManagementView(String name, Frame parent) {
        super(name, parent);

        final JPanel details = new JPanel(new GridLayout(6, 2));
        final JTextField firstName = new JTextField("", 20);
        final JTextField lastName = new JTextField("", 20);
        final JTextField password = new JTextField("", 20);

        details.add(new JLabel("First Name"),0);
        details.add(firstName,1);
        details.add(new JLabel("Last Name"),2);
        details.add(lastName,3);
        details.add(new JLabel("Password"),4);
        details.add(password,5);

        JButton button = new JButton("OK");
        button.addActionListener(actionEvent -> {
            System.out.println("Button OK pressed");
            String inputFN = firstName.getText();
            String inputLN = lastName.getText();
            String inputP = password.getText();
            Query query = db.executeQuery("select * from users where FirstName='" + inputFN +  "' and LastName='" + inputLN + "';");
            IEmployee e;
            System.out.println(query.toString());
            if(query.size() > 0 && query.get(0).get("Password").equals(inputP)) {
                System.out.println("Password matches in database");
                Iterator<String> o = query.get(0).getColNames();
                while (o.hasNext()){
                    System.out.println(o.next());
                }
                System.out.println("Management level: " + query.get(0).get("ManagementLevel"));
                switch(Integer.parseInt(query.get(0).get("ManagementLevel"))){
                    case 1:
                        System.out.println("User is a hotel manager. Creating Hotel manager instance.");
                        e = new HotelManager(query.get(0).get("FirstName"),query.get(0).get("LastName"),
                                query.get(0).get("Password"),Integer.parseInt(query.get(0).get("Wages")));
                        break;
                    case 2:
                        System.out.println("User is a general manager. Creating General manager instance.");
                        e = new GeneralManager(query.get(0).get("FirstName"),query.get(0).get("LastName"),
                                query.get(0).get("Password"),Integer.parseInt(query.get(0).get("Wages")));
                        break;
                    case 3:
                        System.out.println("User is an employee. Creating Employee instance.");
                        e = new Employee(query.get(0).get("FirstName"),query.get(0).get("LastName"),
                                query.get(0).get("Password"),Integer.parseInt(query.get(0).get("Wages")));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + query.get(0).get("ManagementLevel"));
                }
                System.out.println("Showing management details.");
                //details.removeAll();
                context = new ContextObject(e.getFirstName(), e.getLastName(), new Timestamp(System.currentTimeMillis()));
                System.out.println(context.getLoginTime());
                interceptor.preLoginReply(context);
                showManagementDetails(e);
            }
            else {
                System.out.println("Input given does not exist in the database or does not match");
            }
        });

        details.add(new JLabel(""),6);
        details.add(button, 7);
        this.add(details);
    }

    private void showManagementDetails(final IEmployee e) {
        this.removeAll();
        final JPanel managementDetails = new JPanel(new GridLayout(6,2));
        final CommandJButton logout = new CommandJButton(new DoNothingCommand());
        logout.setCommand(new BackCommand(CareTaker.getInstance().get(1), parent));
        if (e.getManagementLevel() < 3) {
            System.out.println("Manager using system");
            JButton showEmployees = new JButton("Show Employees");
            showEmployees.addActionListener(actionEvent -> showEmployees(e));
            JButton showTotalWages = new JButton("Show Total Wages");
            showTotalWages.addActionListener(actionEvent -> showTotalWages(e));
            final JButton addEmployee = new JButton("Add Employee");
            addEmployee.addActionListener(actionEvent -> addRemoveEmployee(e, "Add"));
            JButton removeEmployee = new JButton("Remove Employee");
            removeEmployee.addActionListener(actionEvent -> addRemoveEmployee(e, "Remove"));
            logout.setText("Logout");
            logout.addActionListener(actionEvent -> {
                context.setLogoutTime(new Timestamp(System.currentTimeMillis()));
                System.out.println(context.getLogoutTime());
                interceptor.postLogoutReply(context);
                logout.execute();
            });
            managementDetails.add(showEmployees, 0);
            managementDetails.add(showTotalWages, 1);
            managementDetails.add(addEmployee, 2);
            managementDetails.add(removeEmployee, 3);
            managementDetails.add(logout, 4);
        } else {
            System.out.println("Employee using system");
            JButton showWages = new JButton("Show Wages");
            showWages.addActionListener(actionEvent -> showTotalWages(e));
            logout.setText("Logout");
            logout.addActionListener(actionEvent -> {
                context.setLogoutTime(new Timestamp(System.currentTimeMillis()));
                System.out.println(context.getLogoutTime());
                interceptor.postLogoutReply(context);
                logout.execute();
            });
            managementDetails.add(showWages,0);
            managementDetails.add(logout, 1);
        }
        this.add(managementDetails);
        this.revalidate();
        this.repaint();
    }


    private void addRemoveEmployee(final IEmployee e, final String action) {
        this.removeAll();
        System.out.println("Adding/Removing employee");
        final JPanel addRemoveDetails = new JPanel(new GridLayout(5,2));
        final JTextField firstName = new JTextField("", 20);
        final JTextField lastName = new JTextField("", 20);
        JButton actionButton = new JButton(action);
        JButton backButton = new JButton("Back");
        actionButton.addActionListener(actionEvent -> {
            String inputFN = firstName.getText();
            String inputLN = lastName.getText();
            boolean notFound = true;
            Query q = db.executeQuery("select * from users where FirstName='" + inputFN + "';");
            if(q.size() != 0) {
                if(q.get(0).get("LastName").equals(inputLN)){
                    if(action.equals("Add")) {
                        e.addEmployee(new Employee(inputFN, inputLN, q.get(0).get("Password"), Integer.parseInt(q.get(0).get("Wages"))));
                        notFound = false;
                        System.out.println("Employee added");
                    }
                    else if(action.equals("Remove")) {
                        List<IEmployee> currentEmployeeList = e.accept(employeeListVisitor);
                        Employee toBeRemoved = null;
                        for (int i = 0; i < currentEmployeeList.size() && notFound; i++) {
                            if (q.get(0).get("FirstName").equals(currentEmployeeList.get(i).getFirstName()) && q.get(0).get("LastName").equals(currentEmployeeList.get(i).getLastName())) {
                                toBeRemoved = (Employee) currentEmployeeList.get(i);
                                notFound = false;
                            }
                        }
                        if (!notFound) {
                            e.removeEmployee(toBeRemoved);
                            System.out.println("Employee removed");
                        }
                    }
                    if(notFound) {
                        System.out.println("Input given does not exist in the database or employee list");
                    } else {
                        showManagementDetails(e);
                    }
                } else {
                    System.out.println("First name exists but last name does not match");
                }
            }
            else {
                System.out.println("This employee does not exist in the database");
            }
        });
        backButton.addActionListener(actionEvent -> showManagementDetails(e));
        addRemoveDetails.add(new JLabel("First Name"),0);
        addRemoveDetails.add(firstName, 1);
        addRemoveDetails.add(new JLabel("Last Name"),2);
        addRemoveDetails.add(lastName, 3);
        addRemoveDetails.add(backButton, 4);
        addRemoveDetails.add(actionButton, 5);

        this.add(addRemoveDetails);
        this.revalidate();
        this.repaint();
    }

    private void showEmployees(final IEmployee e) {
        this.removeAll();
        System.out.println("Showing employee list");
        List<IEmployee> employeeList = e.accept(employeeListVisitor);
        JPanel showEmployeeDetails = new JPanel(new GridLayout(employeeList.size(), 2));
        JButton goBackButton = new JButton("Return to Management menu");
        goBackButton.addActionListener(actionEvent -> showManagementDetails(e));
        showEmployeeDetails.add(new JLabel("Employee list for " + e.getFirstName() + " " + e.getLastName()),0);
        System.out.println("Employee list size: " + employeeList.size());
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("Inside for loop");
            showEmployeeDetails.add(new JLabel(employeeList.get(i).getFirstName() + " " + employeeList.get(i).getLastName()), i + 1);
        }
        showEmployeeDetails.add(goBackButton);
        this.add(showEmployeeDetails);
        this.revalidate();
        this.repaint();
    }

    private void showTotalWages(final IEmployee e) {
        this.removeAll();
        JPanel showTotalWagesDetails = new JPanel(new GridLayout(2, 2));
        JButton goBackButton = new JButton("Return to Management menu");
        goBackButton.addActionListener(actionEvent -> showManagementDetails(e));
        if(e.getManagementLevel() < 3 ) {
            int totalWages = e.accept(totalWagesVisitor);
            showTotalWagesDetails.add(new JLabel("Total wages: " + totalWages),0);
        } else {
            int wages = e.getWages();
            showTotalWagesDetails.add(new JLabel("Wages: " + wages), 0);
        }

        showTotalWagesDetails.add(goBackButton, 1);

        this.add(showTotalWagesDetails);
        this.revalidate();
        this.repaint();
    }
}
