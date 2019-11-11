package ie.ul.hbs2.GUI;

import ie.ul.hbs2.database.DatabaseHelper;
import ie.ul.hbs2.database.Query;
import ie.ul.hbs2.management.*;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class ManagementView extends View {

    private final TotalWagesVisitor totalWagesVisitor = new TotalWagesVisitorImpl();
    private final EmployeeListVisitor employeeListVisitor = new EmployeeListVisitorImpl();
    private final DatabaseHelper db = DatabaseHelper.getInstance();

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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Button OK pressed");
                String inputFN = firstName.getText();
                String inputLN = lastName.getText();
                String inputP = password.getText();
                Query query = db.executeQuery("select * from users where FirstName='" + inputFN +  "' and LastName='" + inputLN + "';");
                IEmployee e;
                System.out.println(query.toString());
                if(query.get(0).get("Password").equals(inputP)) {
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
                    showManagementDetails(e);
                }
                else {
                    //details.removeAll();
                    showErrorDetails();
                }
            }
        });

        details.add(new JLabel(""),6);
        details.add(button, 7);
        this.add(details);
    }

    private void showErrorDetails() {
        this.removeAll();
        JPanel errorDetails = new JPanel(new GridLayout(2,2));
        JButton backButton = new JButton("Go back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO go back to previous panel etc
            }
        });
        errorDetails.add(new JLabel("Input given does not exist in the database or does not match"),0);
        errorDetails.add(backButton,1);

        this.add(errorDetails);
        this.revalidate();
        this.repaint();
    }

    private void showManagementDetails(final IEmployee e) {
        this.removeAll();
        final JPanel managementDetails = new JPanel(new GridLayout(5,2));


        if (e.getManagementLevel() < 3) {
            System.out.println("Manager using system");
            JButton showEmployees = new JButton("Show Employees");
            showEmployees.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    showEmployees(e);
                }
            });
            JButton showTotalWages = new JButton("Show Total Wages");
            showTotalWages.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    showTotalWages(e);
                }
            });
            final JButton addEmployee = new JButton("Add Employee");
            addEmployee.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    addRemoveEmployee(e, "Add");
                }
            });
            JButton removeEmployee = new JButton("Remove Employee");
            removeEmployee.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    addRemoveEmployee(e, "Remove");
                }
            });
            managementDetails.add(showEmployees, 0);
            managementDetails.add(showTotalWages, 1);
            managementDetails.add(addEmployee, 2);
            managementDetails.add(removeEmployee, 3);
        } else {
            System.out.println("Employee using system");
            JButton showWages = new JButton("Show Wages");
            managementDetails.add(showWages,0);
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
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String inputFN = firstName.getText();
                String inputLN = lastName.getText();
                Query q = db.executeQuery("select * from users where FirstName='" + inputFN + "';");
                if(q.get(0).get("LastName").equals(inputLN)){
                    if(action.equals("Add")) {
                        e.addEmployee(new Employee(inputFN, inputLN, q.get(0).get("Password"), Integer.parseInt(q.get(0).get("Wages"))));
                        System.out.println("Employee added");
                    }
                    else if(action.equals("Remove")) {
                        List<IEmployee> currentEmployeeList = e.accept(employeeListVisitor);
                        Employee toBeRemoved = null;
                        boolean notFound = true;
                        for (int i = 0; i < currentEmployeeList.size() && notFound; i++) {
                            if (q.get(0).get("FirstName").equals(currentEmployeeList.get(i).getFirstName()) && q.get(0).get("LastName").equals(currentEmployeeList.get(i).getLastName())) {
                                toBeRemoved = (Employee) currentEmployeeList.get(i);
                                notFound = false;
                            }
                        }
                        e.removeEmployee(toBeRemoved);
                        System.out.println("Employee removed");
                    }
                    showManagementDetails(e);
                } else {
                    showErrorDetails();
                }
            }
        });
        addRemoveDetails.add(new JLabel("First Name"),0);
        addRemoveDetails.add(firstName, 1);
        addRemoveDetails.add(new JLabel("Last Name"),2);
        addRemoveDetails.add(lastName, 3);
        addRemoveDetails.add(actionButton, 4);

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
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showManagementDetails(e);
            }
        });
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
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showManagementDetails(e);
            }
        });
        int totalWages = e.accept(totalWagesVisitor);
        showTotalWagesDetails.add(new JLabel("Total wages: " + totalWages),0);
        showTotalWagesDetails.add(goBackButton, 1);

        this.add(showTotalWagesDetails);
        this.revalidate();
        this.repaint();
    }
}
