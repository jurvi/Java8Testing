package com.jjarvela;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jjarvela on 24/01/17.
 */
@SessionScoped
@Named
public class DataTableController implements Serializable {

    @Getter
    @Setter
    private List<String> selectedNumbers = new ArrayList<>();

    @Getter
    @Setter
    private List<String> tableOneList = new ArrayList<>();

    @Setter
    @Getter
    private List<String> tableTwoList = new ArrayList<>();

    /**
     * Clear the selections
     */
    private void clearSelections() {
        selectedNumbers = new ArrayList<>();
    }

    /**
     * Move selected items to list one and remove them from list two
     */
    public void moveToListOne() {
        selectedNumbers.forEach(
            number -> {
                tableTwoList.remove(number);
                tableOneList.add(number);
            });

    }

    /**
     * Move number from list one to list two, also preselect it so it be checked in list two after update
     * 
     * @param number
     */
    public void moveToListTwo(String number) {
        tableOneList.remove(number);
        tableTwoList.add(number);
        clearSelections();
        selectedNumbers.add(number);
    }

    /**
     * Format the lists and clear selections on new page load
     */
    public void onLoad() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        // See that we're not handling POSTs or failed validations.
        if (!facesContext.isPostback() && !facesContext.isValidationFailed()) {
            tableOneList = new ArrayList<>();
            tableTwoList = new ArrayList<>();

            IntStream.range(1, 20).forEach(
                d -> tableOneList.add(Integer.toString(d)));

            IntStream.range(20, 31).forEach(
                d -> tableTwoList.add(Integer.toString(d)));

            clearSelections();
        }
    }

}
