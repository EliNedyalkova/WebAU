package common;

public abstract class BasePage<ElementsT extends BaseElements, AssertionsT extends BaseAssertions<ElementsT>> {
    protected abstract String getUrl();

    protected ElementsT elements() {
        return NewInstanceFactory.createByTypeParameter(getClass(), 0);
    }

    public AssertionsT assertions() {
        return NewInstanceFactory.createByTypeParameter(getClass(), 1);
    }

    public void navigate(String part) {
        Driver.getBrowser().navigate().to(getUrl().concat(part));
    }

    public void navigate() {
        Driver.getBrowser().navigate().to(getUrl());
    }
}