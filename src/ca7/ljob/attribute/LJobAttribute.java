package ca7.ljob.attribute;

/**
 * Represents an attribute of an LJob. This is later mapped to the actual attribute.
 *
 * @author michael.baljet
 * @see HeaderAttribute
 * @see JobInformationAttribute
 *
 */
public interface LJobAttribute {

    /**
     * Returns the token of this attribute.
     * @return token of this attribute.
     */
    public String token();

}
