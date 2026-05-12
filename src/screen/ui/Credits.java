package screen.ui;

import graphic.Graphic;
import graphic.GraphicState;
import screen.Screen;
import screen.ScreenBase;
import screen.ScreenState;
import javax.swing.*;
import java.awt.*;

public class Credits extends ScreenBase {
    private static final int FRAME_WIDTH = 1024;
    private static final int FRAME_HEIGHT = 1024;
    private static final int FRAME_COUNT = 1;

    private static final int[] BG_BOUNDS = {0, 0, 706, 683};

    private Graphic bgGraphic;

    public Credits(Screen screen) {
        super(screen);
    }

    @Override
    protected void initializeUI() {
        bgGraphic = new Graphic();
        loadSprites(bgGraphic);
        bgGraphic.loopAnimation(GraphicState.IDLE);
        bgGraphic.setAnimationSpeed(80);

        JButton backbutton = createButton("", 130, 150, 85, 33);
        backbutton.setOpaque(false);
        backbutton.setContentAreaFilled(false);
        backbutton.setBorderPainted(false);
        backbutton.setFocusable(false);
        backbutton.addActionListener(e -> {
            screen.changeScreen(ScreenState.SELECT_MODE);
        });
    }

    @Override
    protected void onAnimationTick() {
        bgGraphic.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        bgGraphic.draw(g, BG_BOUNDS[0], BG_BOUNDS[1], BG_BOUNDS[2], BG_BOUNDS[3]);
    }

    private void loadSprites(Graphic graphic) {
        graphic.loadRow("/sprites/credits_screen.png", FRAME_WIDTH, FRAME_HEIGHT, FRAME_COUNT);
    }
}