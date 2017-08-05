package com.mykhailo.kolpakov.behavior;

public class Memento {
	public static void main(String[] args) {
		Game game = new Game();
		game.set("level 2", 2);
		System.out.println(game);
		File file = new File();
		file.setSave(game.save());
		
		game.set("level 3", 55);
		System.out.println(game);
		
		game.load(file.getSave());
		System.out.println(game);
	
	}
}

class Game {
	private String level;
	private int ms;

	public void set(String level, int ms) {
		this.level = level;
		this.ms = ms;
	}
	
	public void load(Save save) {
		level = save.getLevel();
		ms = save.getMs();
	}
	
	@Override
	public String toString() {
		return "Game [level=" + level + ", ms=" + ms + "]";
	}

	public Save save() {
		return new Save(level, ms);
	}
}

class Save {
	private String level;
	private int ms;

	public Save(String level, int ms) {
		this.level = level;
		this.ms = ms;
	}

	public int getMs() {
		return ms;
	}

	public String getLevel() {
		return level;
	}

}

class File {
	Save save;

	public Save getSave() {
		return save;
	}

	public void setSave(Save save) {
		this.save = save;
	}

}