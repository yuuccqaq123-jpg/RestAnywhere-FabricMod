# Rest Anywhere (Fabric Mod)

**Rest Anywhere** 是一个适用于 Minecraft 1.20.1 的 Fabric 模组。正如其名，它允许玩家在游戏世界的任何地方坐下休息，并包含自然的物理交互和输入限制。

🔗 **GitHub 仓库**: [https://github.com/yuuccqaq123-jpg/RestAnywhere-FabricMod](https://github.com/yuuccqaq123-jpg/RestAnywhere-FabricMod)

## ✨ 功能特性 (Features)

* **随时随地休息**：不再需要楼梯或台阶，你可以在任何方块上坐下。
* **输入限制**：当处于“坐下”状态时，玩家的移动键（WASD）、跳跃和潜行将被禁用，防止意外滑步。
* **物理交互**：通过修改客户端物理逻辑，锁定玩家的水平移动速度，同时保留垂直重力（所以如果在半空中坐下，你依然会掉下去）。
* **视觉调整**：(包含在代码结构中) 调整玩家模型以呈现坐下的姿态。

## 🛠️ 安装环境 (Requirements)

要运行此模组，你需要：

* **Minecraft**: 1.20.1
* **Java**: 17 或更高版本
* **Fabric Loader**: 0.14.21+ (推荐使用最新版)
* **Fabric API**: 必需的前置模组

## 🚀 安装指南 (Installation)

1. 下载并安装对应版本的 **Fabric Loader**。
2. 下载本模组的 `.jar` 文件。
3. 确保你已经下载了 [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) 并放入了 mods 文件夹。
4. 将本模组放入 `.minecraft/mods` 文件夹中。
5. 启动游戏。

## 🎮 使用方法 (Usage)

*(注：由于未看到具体的按键绑定代码，以下基于常见设定推测，请根据实际 `RestAnywhereClient` 中的设定修改此部分)*

1. 进入游戏后，在按键设置中找到 **Rest Anywhere** 的绑定按键（通常默认为 `R` 或 `G`，请在游戏中确认）。
2. 按下按键即可切换 **坐下/站起** 状态。
3. 坐下时，你将无法移动，再次按下按键即可站起并恢复行动。

## 🏗️ 构建指南 (Building from source)

如果你想自己编译这个项目，请按照以下步骤操作：

1. 克隆仓库到本地：
```bash
git clone https://github.com/yuuccqaq123-jpg/RestAnywhere-FabricMod.git
cd RestAnywhere-FabricMod

```


2. 根据你的操作系统运行构建命令：
* **Windows**:
```cmd
gradlew build

```


* **Linux/macOS**:
```bash
./gradlew build

```




3. 构建完成后，模组文件将生成在 `build/libs/` 目录下。

## 🤝 贡献 (Contributing)

欢迎提交 Issue 或 Pull Request 来改进这个模组！

## 📄 许可证 (License)

本项目采用 **MIT License** 开源。详情请参阅 [LICENSE](https://www.google.com/search?q=LICENSE) 文件。

---

**Author**: Yuucc
