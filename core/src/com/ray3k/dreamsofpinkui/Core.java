package com.ray3k.dreamsofpinkui;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Core extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;

    @Override
    public void create() {
        skin = new Skin(Gdx.files.internal("dreams-of-pink.json"));
        
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        
        Table root = new Table();
        root.setFillParent(true);
        root.setBackground(skin.getDrawable("bg"));
        stage.addActor(root);
        
        root.defaults().space(15);
        Image image = new Image(skin, "logo");
        root.add(image);
        
        root.row();
        Label label = new Label("Log in", skin);
        root.add(label);
        
        root.row();
        TextField textField = new TextField(null, skin);
        textField.setMessageText("user");
        root.add(textField).minWidth(300);
        
        root.row();
        textField = new TextField(null, skin);
        textField.setMessageText("password");
        root.add(textField).minWidth(300);
        
        root.row();
        CheckBox checkBox = new CheckBox("Would you like spam sent to your email?", skin);
        root.add(checkBox);
        
        root.row();
        TextButton textButton = new TextButton("LOG IN", skin);
        root.add(textButton).minWidth(200);
        
        root.row();
        textButton = new TextButton("Forgot your password?", skin, "link");
        root.add(textButton);
        
        root.row();
        final ProgressBar progressBar = new ProgressBar(0, 100, 1, false, skin);
        progressBar.setValue(50);
        root.add(progressBar).width(239);
        
        root.row();
        final Slider slider = new Slider(0, 100, 1, false, skin);
        slider.setValue(50);
        root.add(slider);
        slider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                progressBar.setValue(slider.getValue());
            }
        });
        
        root.row();
        SelectBox selectBox = new SelectBox(skin);
        selectBox.setItems("Pink", "Flamingo", "Magenta", "Bubble Gum", "Salmon", "Fuchsia", "Ruby", "Lavender", "Watermelon");
        root.add(selectBox).minWidth(200);
        
        root.row();
        Table table = new Table();
        root.add(table);
        
        table.defaults().minWidth(200);
        textButton = new TextButton("Log in with SpaceBook", skin, "square");
        table.add(textButton);
        
        image = new Image(skin, "pink");
        image.setScaling(Scaling.stretch);
        table.add(image).growY().minWidth(1);
        
        textButton = new TextButton("Register a new account", skin, "square");
        table.add(textButton);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        if (Gdx.input.isKeyPressed(Keys.F5)) {
            dispose();
            create();
        }
        
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
