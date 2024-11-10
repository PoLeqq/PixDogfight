package pl.poleq.pixdogfight.entity.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Size {
    private int width;
    private int height;

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.setSize(width, height);
    }

    public void setHeight(int height) {
        this.setSize(width, height);
    }
}
