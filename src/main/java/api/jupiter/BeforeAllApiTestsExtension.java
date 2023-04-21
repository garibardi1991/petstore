package api.jupiter;

import api.spec.Specification;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BeforeAllApiTestsExtension implements AroundAllTestsExtension {

    @Override
    public void beforeAllTests(ExtensionContext context) {
        Specification.installSpecification200();
    }
}
