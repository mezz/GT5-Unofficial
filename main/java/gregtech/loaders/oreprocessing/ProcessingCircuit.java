package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.item.ItemStack;

public class ProcessingCircuit implements gregtech.api.interfaces.IOreRecipeRegistrator
{
  public ProcessingCircuit()
  {
    OrePrefixes.circuit.add(this);
  }
  
  public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack)
  {
    switch (aMaterial) {
    case Good: case Advanced: case Data: case Elite: case Master: case Ultimate: 
      if (!gregtech.api.util.GT_OreDictUnificator.isBlacklisted(aStack)) GT_ModHandler.removeRecipeByOutput(aStack);
      break;
    case Primitive: 
      GT_ModHandler.removeRecipeByOutput(aStack);
      GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Primitive.get(1L, new Object[0]), new Object[] { GT_ModHandler.getIC2Item("casingadviron", 1L), OrePrefixes.wireGt01.get(Materials.RedAlloy), OrePrefixes.wireGt01.get(Materials.RedAlloy), OrePrefixes.wireGt01.get(Materials.Tin) });
      break;
    case Basic: 
      GT_ModHandler.removeRecipeByOutput(aStack);
      GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Basic.get(1L, new Object[0]), new Object[] { "WWW", "CPC", "WWW", Character.valueOf('C'), OrePrefixes.circuit.get(Materials.Primitive), Character.valueOf('W'), OreDictNames.craftingWireCopper, Character.valueOf('P'), OrePrefixes.plate.get(Materials.Steel) });
      GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Basic.get(1L, new Object[0]), new Object[] { "WCW", "WPW", "WCW", Character.valueOf('C'), OrePrefixes.circuit.get(Materials.Primitive), Character.valueOf('W'), OreDictNames.craftingWireCopper, Character.valueOf('P'), OrePrefixes.plate.get(Materials.Steel) });
      GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Basic.get(1L, new Object[0]), new Object[] { ItemList.Circuit_Integrated.getWildcard(1L, new Object[0]) });
    }
  }
}


/* Location:              F:\Torrent\minecraft\jdgui test\gregtech_1.7.10-5.07.07-dev.jar!\gregtech\loaders\oreprocessing\ProcessingCircuit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1-SNAPSHOT-20140817
 */