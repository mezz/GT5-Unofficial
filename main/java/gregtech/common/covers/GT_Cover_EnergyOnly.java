package gregtech.common.covers;

import gregtech.api.interfaces.tileentity.ICoverable;
import gregtech.api.interfaces.tileentity.IMachineProgress;
import gregtech.api.util.GT_CoverBehavior;
import gregtech.api.util.GT_Utility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fluids.Fluid;

public class GT_Cover_EnergyOnly
  extends GT_CoverBehavior
{
  public int onCoverScrewdriverclick(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity, EntityPlayer aPlayer, float aX, float aY, float aZ)
  {
    aCoverVariable = (aCoverVariable + 1) % 3;
    if (aCoverVariable == 0) {
      GT_Utility.sendChatToPlayer(aPlayer, "Allow");
    }
    if (aCoverVariable == 1) {
      GT_Utility.sendChatToPlayer(aPlayer, "Allow (conditional)");
    }
    if (aCoverVariable == 2) {
      GT_Utility.sendChatToPlayer(aPlayer, "Disallow (conditional)");
    }
    return aCoverVariable;
  }
  
  public float getBlastProofLevel(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity)
  {
    return 20.0F;
  }
  
  public boolean letsRedstoneGoIn(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity)
  {
    return false;
  }
  
  public boolean letsRedstoneGoOut(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity)
  {
    return false;
  }
  
  public boolean letsEnergyIn(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity)
  {
    if ((aCoverVariable > 1) && ((aTileEntity instanceof IMachineProgress))) {
      if (((IMachineProgress)aTileEntity).isAllowedToWork() != aCoverVariable < 2) {
        return false;
      }
    }
    return true;
  }
  
  public boolean letsEnergyOut(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity)
  {
    if ((aCoverVariable > 1) && ((aTileEntity instanceof IMachineProgress))) {
      if (((IMachineProgress)aTileEntity).isAllowedToWork() != aCoverVariable < 2) {
        return false;
      }
    }
    return true;
  }
  
  public boolean letsFluidIn(byte aSide, int aCoverID, int aCoverVariable, Fluid aFluid, ICoverable aTileEntity)
  {
    return false;
  }
  
  public boolean letsFluidOut(byte aSide, int aCoverID, int aCoverVariable, Fluid aFluid, ICoverable aTileEntity)
  {
    return false;
  }
  
  public boolean letsItemsIn(byte aSide, int aCoverID, int aCoverVariable, int aSlot, ICoverable aTileEntity)
  {
    return false;
  }
  
  public boolean letsItemsOut(byte aSide, int aCoverID, int aCoverVariable, int aSlot, ICoverable aTileEntity)
  {
    return false;
  }
  
  public boolean isGUIClickable(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity)
  {
    return false;
  }
  
  public boolean manipulatesSidedRedstoneOutput(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity)
  {
    return false;
  }
  
  public boolean onCoverRightclick(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity, EntityPlayer aPlayer, float aX, float aY, float aZ)
  {
    return false;
  }
  
  public boolean onCoverRemoval(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity, boolean aForced)
  {
    return true;
  }
}


/* Location:           F:\Torrent\minecraft\jd-gui-0.3.6.windows\gregtech_1.7.10-5.07.07-dev.jar
 * Qualified Name:     gregtech.common.covers.GT_Cover_EnergyOnly
 * JD-Core Version:    0.7.0.1
 */