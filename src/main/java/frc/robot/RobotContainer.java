/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.SimplePOVDrive;
import frc.robot.commands.YHCDrive;
import frc.robot.commands.AdvancedTankDrive;
import frc.robot.commands.BlockyTankDrive;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.PowerManager;
import frc.robot.subsystems.Storage;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private XboxController joystick1;
    private XboxController joystick2;

    private final Chassis chassis;
    private final Intake intake;
    private final PowerManager powerManager;
    private final Storage storage;
    private Turret turret;

    private final AdvancedTankDrive advancedTankDrive;
    private final BlockyTankDrive blockyTankDrive;
    private final SimplePOVDrive simplePOVDrive;
    private final YHCDrive yhcDrive;

    public RobotContainer() {
        joystick1 = new XboxController(0);
        joystick2 = new XboxController(1);

        chassis = new Chassis();
        intake = new Intake();
        powerManager = new PowerManager();
        storage = new Storage();
        turret = new Turret();

        advancedTankDrive = new AdvancedTankDrive(chassis, joystick1);
        blockyTankDrive = new BlockyTankDrive(chassis, joystick1);
        simplePOVDrive = new SimplePOVDrive(chassis, joystick1);
        yhcDrive = new YHCDrive(chassis, joystick1);

        configureButtonBindings();
    }

    private void configureButtonBindings() {
    }

    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return advancedTankDrive;
    }

    public Command getTeleopCommand() {
        return blockyTankDrive;
    }
}
