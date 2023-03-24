import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private final List<Component> components;

    public GameObject() {
        components = new ArrayList<>();
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (Component comp : components) {
            if (componentClass.isAssignableFrom(comp.getClass())) {
                return componentClass.cast(comp);
            }
        }
        return null;
    }

    public <T extends Component> void removeComponent(Class<T> componentClass) {
        for (int i = 0; i < components.size(); i++) {
            Component comp = components.get(i);
            if (componentClass.isAssignableFrom(comp.getClass())) {
                components.remove(i);
                return;
            }
        }
    }

    public void addComponent(Component comp) {
        this.components.add(comp);
        comp.gameObject = this;
    }

    public void update(double dt) {
        for (Component component : components) {
            component.update(dt);
        }
    }

    public void start() {
        for (Component component : components) {
            component.start();
        }
    }
}
