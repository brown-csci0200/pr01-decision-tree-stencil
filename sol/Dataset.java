package sol;

import java.util.List;
import java.util.Random;

import src.AttributeSelection;
import src.IDataset;
import src.Row;

import java.util.*;

/**
 * A class representing a training dataset for the decision tree
 */
// TODO: Uncomment this once you've implemented the methods in the IDataset interface!
public class Dataset /* implements IDataset */ {
    private List<String> attributeList;
    private List<Row> dataObjects;
    private AttributeSelection selectionType;

    /**
     * Constructor for a Dataset object
     * @param attributeList - a list of attributes
     * @param dataObjects -  a list of rows
     * @param selectionType - an enum for which way to select attributes
     */
    public Dataset(List<String> attributeList, List<Row> dataObjects, AttributeSelection selectionType) {
        this.attributeList = new ArrayList<String>(attributeList);
        this.dataObjects = new ArrayList<Row>(dataObjects);
        this.selectionType = selectionType;
    }

//    TODO: Uncomment this once you've completed the constructor!
//    public String getAttributeToSplitOn() {
//        switch (this.selectionType) {
//            case AttributeSelection.ASCENDING_ALPHABETICAL -> {
//                return this.attributeList.stream().sorted().toList().get(0);
//            }
//            case AttributeSelection.DESCENDING_ALPHABETICAL -> {
//                return this.attributeList.stream().sorted().toList().get(this.attributeList.size() - 1);
//            }
//            case AttributeSelection.RANDOM -> {
//                // TODO: Implement random attribute selection!
//            }
//        }
//        throw new RuntimeException("Non-Exhaustive Switch Case");
//    }
//

//    TODO: Uncomment this once you've completed the constructor!
    public String getAttributeToSplitOn() {
        if (this.selectionType == AttributeSelection.ASCENDING_ALPHABETICAL) {
            return this.attributeList.stream().sorted().toList().get(0);
        }
        if (this.selectionType == AttributeSelection.DESCENDING_ALPHABETICAL) {
            return this.attributeList.stream().sorted().toList().get(this.attributeList.size() - 1);
        }
        if (this.selectionType == AttributeSelection.RANDOM) {
            Random r = new Random();
            int randomIndex = r.nextInt(this.attributeList.size());
            return this.attributeList.get(randomIndex);
        }

        throw new RuntimeException("Non-Exhaustive Switch Case");
    }
}
