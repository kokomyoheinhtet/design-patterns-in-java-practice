package OpenClosedPrinciple;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
