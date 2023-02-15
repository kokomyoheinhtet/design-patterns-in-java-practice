package A0_SOLIDDesign.OpenClosedPrinciple;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
