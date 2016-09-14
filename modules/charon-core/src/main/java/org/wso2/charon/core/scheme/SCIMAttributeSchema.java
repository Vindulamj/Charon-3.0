package org.wso2.charon.core.scheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This defines the attributes schema as in SCIM Spec.
 */

public class SCIMAttributeSchema implements AttributeSchema {

    //name of the attribute
    private String name;
    //data type of the attribute
    private SCIMDefinitions.DataType type;
    //Boolean value indicating the attribute's plurality.
    private Boolean multiValued;
    //The attribute's human readable description
    private String description;
    //A Boolean value that specifies if the attribute is required
    private Boolean required;
    //A Boolean value that specifies if the String attribute is case sensitive
    private Boolean caseExact;
    //A SCIM defined value that specifies if the attribute's mutability.
    private SCIMDefinitions.Mutability mutability;
    //A SCIM defined value that specifies when the attribute's value need to be returned.
    private SCIMDefinitions.Returned returned;
    //A SCIM defined value that specifies the uniqueness level of an attribute.
    private SCIMDefinitions.Uniqueness uniqueness;
    //A list specifying the contained attributes. OPTIONAL.
    private ArrayList<SCIMAttributeSchema> subAttributes;
    //A collection of suggested canonical values that MAY be used -OPTIONAL
    private ArrayList<String> canonicalValues;
    //A multi-valued array of JSON strings that indicate the SCIM resource types that may be referenced
    //only applicable for attributes that are of type "reference"
    private ArrayList<SCIMDefinitions.ReferenceType> referenceTypes;

    private SCIMAttributeSchema(String name, SCIMDefinitions.DataType type, Boolean multiValued,
                                String description, Boolean required, Boolean caseExact,
                                SCIMDefinitions.Mutability mutability, SCIMDefinitions.Returned returned,
                                SCIMDefinitions.Uniqueness uniqueness, ArrayList<String> canonicalValues,
                                ArrayList<SCIMDefinitions.ReferenceType> referenceTypes,
                                ArrayList<SCIMAttributeSchema> subAttributes) {
        this.name = name;
        this.type = type;
        this.multiValued = multiValued;
        this.description = description;
        this.required = required;
        this.caseExact = caseExact;
        this.mutability = mutability;
        this.returned = returned;
        this.uniqueness = uniqueness;
        this.subAttributes = subAttributes;
        this.canonicalValues = canonicalValues;
        this.referenceTypes = referenceTypes;
    }

    public static SCIMAttributeSchema createSCIMAttributeSchema(String name, SCIMDefinitions.DataType type,
                                                                Boolean multiValued, String description, Boolean required,
                                                                Boolean caseExact, SCIMDefinitions.Mutability mutability,
                                                                SCIMDefinitions.Returned returned,
                                                                SCIMDefinitions.Uniqueness uniqueness,
                                                                ArrayList<String> canonicalValues,
                                                                ArrayList<SCIMDefinitions.ReferenceType> referenceTypes,
                                                                ArrayList<SCIMAttributeSchema> subAttributes){

        return new SCIMAttributeSchema(name, type, multiValued, description, required, caseExact, mutability,
                                        returned, uniqueness, canonicalValues, referenceTypes, subAttributes);
    }

    public String getName() { return name; }

    public void setName(String name) { this.name=name; }

    public SCIMDefinitions.DataType getType() { return type; }

    public void setType(SCIMDefinitions.DataType type) { this.type=type; }

    public boolean getMultiValued() { return multiValued; }

    public void setMultiValued(boolean isMultiValued) { this.multiValued=isMultiValued; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description=description; }

    public boolean getRequired() { return required; }

    public void setRequired(boolean isRequired) { this.required=isRequired; }

    public boolean getCaseExact() { return caseExact; }

    public void setCaseExact(boolean isCaseExact) { this.caseExact=isCaseExact; }

    public SCIMDefinitions.Mutability getMutability() { return mutability; }

    public void setMutability(SCIMDefinitions.Mutability mutability) { this.mutability=mutability; }

    public SCIMDefinitions.Returned getReturned() { return returned; }

    public void setReturned(SCIMDefinitions.Returned returned) { this.returned=returned; }

    public SCIMDefinitions.Uniqueness getUniqueness() { return uniqueness; }

    public void setUniqueness(SCIMDefinitions.Uniqueness uniqueness) { this.uniqueness=uniqueness; }

    public List<SCIMAttributeSchema> getSubAttributes() { return subAttributes ;}

    public void setSubAttributes(ArrayList<SCIMAttributeSchema> subAttributes) { this.subAttributes = subAttributes; }

    public List<String> getCanonicalValues() { return canonicalValues; }

    public void setCanonicalValues(ArrayList<String> canonicalValues) { this.canonicalValues = canonicalValues; }

    public ArrayList<SCIMDefinitions.ReferenceType> getReferenceTypes() { return referenceTypes; }

    public void setReferenceTypes(ArrayList<SCIMDefinitions.ReferenceType> referenceTypes) { this.referenceTypes = referenceTypes; }
}